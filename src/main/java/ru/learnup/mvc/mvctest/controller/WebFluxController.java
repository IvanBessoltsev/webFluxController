//package ru.learnup.mvc.mvctest.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import ru.learnup.mvc.mvctest.Service.AuthorsService;
//import ru.learnup.mvc.mvctest.Service.BookService;
//import ru.learnup.mvc.mvctest.Service.ClientService;
//import ru.learnup.mvc.mvctest.Service.OrderService;
//import ru.learnup.mvc.mvctest.entity.Authors;
//import ru.learnup.mvc.mvctest.entity.Book;
//import ru.learnup.mvc.mvctest.entity.Client;
//import ru.learnup.mvc.mvctest.entity.Order;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//@RestController
//@RequestMapping("/api")
//
//public class WebFluxController {
//
//    //*******************Инжектим сервисы
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private AuthorsService authorsService;
//    @Autowired
//    private ClientService clientService;
//    @Autowired
//    private OrderService orderService;
//
//    //*********************прописываем маппинги******************
//
//    //---------------Просмотр всех книг
//    @GetMapping("/books")
//    public Flux<List<Book>> showAllBooks() {
//        List<Book> allBooks = bookService.getAllBooks();
//        return Flux.just(allBooks);
//    }
//
//    //---------------Просмотр одной книги
//    @GetMapping("/books/{id}")
//    public Mono<Book> getBook(@PathVariable int id) {
//        Book book = bookService.getBookById(id);
//        return Mono.just(book);
//    }
//
//}
