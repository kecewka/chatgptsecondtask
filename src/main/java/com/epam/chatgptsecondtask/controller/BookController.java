package com.epam.chatgptsecondtask.controller;

import com.epam.chatgptsecondtask.entity.Book;
import com.epam.chatgptsecondtask.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    // Constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/searchByTitle")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/searchByAuthor")
    public List<Book> searchBooksByAuthor(@RequestParam String authorName) {
        return bookService.searchBooksByAuthor(authorName);
    }

    @GetMapping("/searchByGenre")
    public List<Book> searchBooksByGenre(@RequestParam String genreName) {
        return bookService.searchBooksByGenre(genreName);
    }
}
