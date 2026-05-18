package com.johnny.singlegradlespringboot.repository;

import com.johnny.singlegradlespringboot.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where id=?", nativeQuery = true)
    User getUser(@Param("id") int id);
}
