package com.epam.chatgptsecondtask.dao;

import com.epam.chatgptsecondtask.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByNameContaining(String name);
}