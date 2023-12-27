package com.epam.chatgptsecondtask.service;

import com.epam.chatgptsecondtask.dao.GenreRepository;
import com.epam.chatgptsecondtask.entity.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    // Constructor injection
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long id, Genre updatedGenre) {
        Genre existingGenre = getGenreById(id);
        // Update existingGenre properties with updatedGenre
        existingGenre.setName(updatedGenre.getName());
        return genreRepository.save(existingGenre);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    public List<Genre> searchGenresByName(String name) {
        return genreRepository.findByNameContaining(name);
    }
}
