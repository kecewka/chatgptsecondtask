package com.epam.chatgptsecondtask.service;

import com.epam.chatgptsecondtask.dao.AuthorRepository;
import com.epam.chatgptsecondtask.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    // Constructor injection
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        Author existingAuthor = getAuthorById(id);
        // Update existingAuthor properties with updatedAuthor
        existingAuthor.setName(updatedAuthor.getName());
        return authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> searchAuthorsByName(String name) {
        return authorRepository.findByNameContaining(name);
    }
}
