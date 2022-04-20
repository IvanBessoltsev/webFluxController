package ru.learnup.mvc.mvctest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.mvc.mvctest.entity.Book;
import ru.learnup.mvc.mvctest.repository.BooksRepository;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    private BooksRepository bookRepository;

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book getBookById(int id) {
        Book book = null;
        Optional<Book> b = bookRepository.findById(id);
        if (b.isPresent()) {
            book = b.get();
        }
        return book;
    }

    @Transactional
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public List<Book> getBooksSortByTitleAndPrice(String title, double price) {
        if (title != null && price != 0.0) {
            return bookRepository.findAllByTitleContainsAndPriceEquals(title, price);
        } else {
            return bookRepository.findAll();
        }
    }


}