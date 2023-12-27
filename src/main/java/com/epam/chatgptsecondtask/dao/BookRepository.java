package com.epam.chatgptsecondtask.dao;

import com.epam.chatgptsecondtask.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorNameContaining(String authorName);
    List<Book> findByGenreNameContaining(String genreName);
}