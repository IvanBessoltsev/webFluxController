package ru.learnup.mvc.mvctest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.learnup.mvc.mvctest.Service.BookService;
import ru.learnup.mvc.mvctest.entity.Book;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping()
    public String showAllBooks(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("AllBooks", allBooks);
        return "All-Books";
    }

    @GetMapping("/sort")
    public String getSortByTitle(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "price") double price,
            Model model
    ) {
        List<Book> bookSort = bookService.getBooksSortByTitleAndPrice(title, price);
        model.addAttribute("bookSort", bookSort);
        return "Sort-Book";
    }

}
