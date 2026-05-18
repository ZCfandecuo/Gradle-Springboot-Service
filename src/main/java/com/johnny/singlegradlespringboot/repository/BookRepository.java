package com.johnny.singlegradlespringboot.repository;

import com.johnny.singlegradlespringboot.entity.Book;
import com.johnny.singlegradlespringboot.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select * from book where id=?", nativeQuery = true)
    User getBook(@Param("id") int id);
}
