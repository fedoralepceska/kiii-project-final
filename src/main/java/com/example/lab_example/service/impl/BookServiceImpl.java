package com.example.lab_example.service.impl;

import com.example.lab_example.model.Author;
import com.example.lab_example.model.Book;
import com.example.lab_example.model.dto.BookDto;
import com.example.lab_example.model.enumerations.Category;
import com.example.lab_example.model.exceptions.AuthorNotFoundException;
import com.example.lab_example.model.exceptions.BookNotFoundException;
import com.example.lab_example.repository.AuthorRepository;
import com.example.lab_example.repository.BookRepository;
import com.example.lab_example.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto book) {
        Author author = this.authorRepository.findById(book.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthor()));
        this.bookRepository.deleteBookByName(book.getName());
        Book book1 = new Book(book.getName(), book.getCategory(), author, book.getCopies());
        this.bookRepository.save(book1);
        return Optional.of(book1);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto book) {
        Book book1 = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(book.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(book.getAuthor()));
        book1.setName(book.getName());
        book1.setAuthor(author);
        book1.setCopies(book.getCopies());
        book1.setCategory(book.getCategory());
        this.bookRepository.save(book1);
        return Optional.of(book1);
    }

    @Override
    public Optional<Book> create(String name, Category category, Long author, Integer copies) {
        Author author1 = this.authorRepository.findById(author).orElseThrow(() -> new AuthorNotFoundException(author));
        Book book = new Book(name,category,author1,copies);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long author, Integer copies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author1 = this.authorRepository.findById(author).orElseThrow(() -> new AuthorNotFoundException(author));
        book.setName(name);
        book.setAuthor(author1);
        book.setCopies(copies);
        book.setCategory(category);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book MarkAsTaken(Long id) {
        Optional<Book> book = this.findById(id);
        Integer copies = book.get().getCopies() - 1;
        if(copies<=0){
            book.get().setCopies(0);
        }
        else{
            book.get().setCopies(copies);
        }
        return this.bookRepository.save(book.get());
    }
}
