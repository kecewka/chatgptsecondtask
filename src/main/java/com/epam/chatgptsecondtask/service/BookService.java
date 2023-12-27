package com.epam.chatgptsecondtask.service;

import com.epam.chatgptsecondtask.dao.BookRepository;
import com.epam.chatgptsecondtask.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    // Constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id);
        // Update existingBook properties with updatedBook
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setQuantityAvailable(updatedBook.getQuantityAvailable());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> searchBooksByAuthor(String authorName) {
        return bookRepository.findByAuthorNameContaining(authorName);
    }

    public List<Book> searchBooksByGenre(String genreName) {
        return bookRepository.findByGenreNameContaining(genreName);
    }
}
