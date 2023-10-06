package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    HashMap<Integer,Book> bookDb;
    HashMap<String,List<Book>>authorDb;
    public BookRepository(){
        bookDb = new HashMap<>();
        authorDb = new HashMap<>();
    }

    public Book save(Book book){
        Book bk = new Book();
        bk.setId(book.getId());
        bk.setName(book.getName());
        bk.setGenre(book.getGenre());
        bk.setAuthor(book.getAuthor());
        bookDb.put(bk.getId(), bk);
        List<Book>bookListByAuthor = new ArrayList<>();
        bookListByAuthor.add(bk);
        authorDb.put(book.getAuthor(),bookListByAuthor);
        return bk;
    }

    public Book findBookById(int id){
        Book bk = bookDb.get(id);
        return bk;
    }

    public List<Book> findAll(){

        List<Book>lt = new ArrayList<>();
        for(int key : bookDb.keySet()){
            lt.add(bookDb.get(key));
        }
        return lt;
    }

    public void deleteBookById(int id){
        Book bk = bookDb.get(id);
        authorDb.remove(bk.getAuthor());
        bookDb.remove(id);
    }

    public void deleteAll(){
        for(int key : bookDb.keySet()){
            authorDb.remove(bookDb.get(key).getAuthor());
            bookDb.remove(key);
        }
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book>bookList = new ArrayList<>();
        bookList = authorDb.get(author);
        return bookList;

    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> lb = new ArrayList<>();
        for(int key : bookDb.keySet()) {
            if(bookDb.get(key).getGenre().equals(genre)){
                lb.add(bookDb.get(key));
            }
        }
        return lb;
    }
}
