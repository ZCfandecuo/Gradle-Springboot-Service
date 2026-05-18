package com.johnny.singlegradlespringboot.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class RedisTemplateConfig {

    @Autowired
    StringRedisTemplate redisTemplate;
//    @Autowired RedisTemplate<String, Map<String, Double>> redisTemplate;
private static final ObjectMapper mapper = new ObjectMapper();

//    @PostConstruct
    void initValue() throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 1; i < 8; i++) {
            for (int j = 10; j < 70; j++) {
                for (int k = 10; k < 34; k++) {
                    map.put("20240"+i+"1"+j+"0"+k, "98.75");
                }
            }
        }
        setValue("fx.spot", map);
    }

    public void setValue(String key, Map<String, String> value) throws JsonProcessingException {
        redisTemplate.opsForValue().set(key, mapper.writeValueAsString(value));
    }

    public String getValue(String key) {
        return (String) redisTemplate.opsForHash().get("fx.spot", key);
    }

}

    