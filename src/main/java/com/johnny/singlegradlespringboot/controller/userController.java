package com.johnny.singlegradlespringboot.controller;

import com.johnny.singlegradlespringboot.entity.Book;
import com.johnny.singlegradlespringboot.entity.User;
import com.johnny.singlegradlespringboot.redis.RedisConnection;
import com.johnny.singlegradlespringboot.redis.RedisTemplateConfig;
import com.johnny.singlegradlespringboot.repository.BookRepository;
import com.johnny.singlegradlespringboot.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("rest")
public class userController {
    @Resource
    UserRepository userRepository;
    @Resource
    BookRepository bookRepository;
    @Resource
    RedisConnection redisConnection;
    @Resource
    RedisTemplateConfig redisTemplateConfig;
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/get/user")
    public ResponseEntity<String> getUser(@RequestParam("id") String user) {
        return ResponseEntity.ok(redisTemplateConfig.getValue(user));
    }

    @GetMapping("/get/map")
    public ResponseEntity<String> getMap(@RequestParam("tag") String tag) {
        return ResponseEntity.ok(redisTemplateConfig.getValue(tag));
    }

    @PostMapping("/save/book")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/get/book")
    public ResponseEntity<User> getBook(@RequestParam("id") int id) {
        return ResponseEntity.ok(bookRepository.getBook(id));
    }

//    @PostConstruct
//    private void initMethod(){
//        List<User> user = new LinkedList<>();
//        User user1 = new User("johnny", "BaiDu", 25);
//        User user2 = new User("johnson", "Ali", 31);
//        User user3 = new User("jenny", "Tencent", 19);
//        user.add(user1);
//        user.add(user2);
//        userRepository.saveAll(user);
//    }


}
