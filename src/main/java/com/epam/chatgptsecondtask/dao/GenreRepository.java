package com.epam.chatgptsecondtask.dao;

import com.epam.chatgptsecondtask.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByNameContaining(String name);
}