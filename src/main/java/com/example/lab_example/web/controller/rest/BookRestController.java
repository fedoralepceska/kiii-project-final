package com.example.lab_example.web.controller.rest;

import com.example.lab_example.model.Book;
import com.example.lab_example.model.dto.BookDto;
import com.example.lab_example.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://gentle-journey-92804.herokuapp.com")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll() {
        return this.bookService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.edit(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/markAsTaken/{id}")
    public Book markAsTaken(@PathVariable Long id){
        return this.bookService.MarkAsTaken(id);
    }
}
