package com.johnny.singlegradlespringboot.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.johnny.singlegradlespringboot.pojo.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConnection {

   @Autowired
   StringRedisTemplate stringRedisTemplate;

   private static final ObjectMapper mapper = new ObjectMapper();

//   @PostConstruct
   private void getRedisConnection() throws JsonProcessingException {
      User user = new User("Johnny", 27, "Citi");
      stringRedisTemplate.opsForValue().set("user",mapper.writeValueAsString(user));
      String user1 = stringRedisTemplate.opsForValue().get("user");
      System.out.println(user1);

   }

   public String getValue(String key){
      return stringRedisTemplate.opsForValue().get(key);
   }

   public String setValue(String key, String value){
      try {
         stringRedisTemplate.opsForValue().set(key, value);
         return "Success";
      }catch (Exception e){
         return "Failed";
      }
   }

   public static void main(String[] args) {
      String property = System.getProperty("java.security.manager");
      System.out.println("result: "+property);
   }
}
