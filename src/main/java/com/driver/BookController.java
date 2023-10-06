package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/find-book-by-id")
    public ResponseEntity findBookById(@RequestParam("id")String id) {
            Book bk = bookService.findBookById(id);
            return new ResponseEntity<>(bk,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-book-by-id")
    public ResponseEntity deleteBookById(@RequestParam String id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book Delete Succesfully",HttpStatus.ACCEPTED);
    }
    @GetMapping("/all-book")
    public ResponseEntity findAllBooks(){
        List<Book> book = bookService.findAllBooks();
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-book")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("Delete Success",HttpStatus.OK);
    }
    @GetMapping("/find-book-by-author")
    public ResponseEntity findBooksByAuthor(@RequestParam("author")String author) {
        List<Book> bk = bookService.findBooksByAuthor(author);
        return new ResponseEntity(bk,HttpStatus.OK);
    }
    @GetMapping("/find-book-by-genre")
    public ResponseEntity findBooksByGenre(@RequestParam String genre){
        List<Book> bk = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(bk,HttpStatus.OK);
    }

}
