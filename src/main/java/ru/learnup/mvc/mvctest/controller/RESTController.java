//package ru.learnup.mvc.mvctest.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
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
//@Controller
//@RestController
//@RequestMapping("/api")
//@Secured({"ADMIN", "USER"})
//public class RESTController {
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
//
//    @GetMapping("/books")
//    public List<Book> showAllBooks() {
//        List<Book> allBooks = bookService.getAllBooks();
//        return allBooks;
//    }
//
//    //---------------Просмотр одной книги
//    @GetMapping("/books/{id}")
//    public Book getBook(@PathVariable int id) {
//        Book book = bookService.getBookById(id);
//        return book;
//    }
//
//    //---------------Удаление книги
//    @DeleteMapping("/books/{id}")
//    @Secured("ADMIN")
//    public void deleteBook(int id) {
//        bookService.deleteBook(id);
//    }
//
//    //---------------Сохранение книги
//    @PostMapping("/books/")
//    @Secured("ADMIN")
//    public void saveBook(Book book) {
//        bookService.saveBook(book);
//    }
//
//    //---------------Удаление автора
//    @DeleteMapping("/authors/{id}")
//    @Secured("ADMIN")
//    public void deleteAuthor(int id) {
//        authorsService.deleteAuthor(id);
//    }
//
//    //---------------Просмотр всех авторов
//    @GetMapping("/authors")
//    public List<Authors> showAllAuthors() {
//        List<Authors> allAuthors = authorsService.getAllAuthors();
//        return allAuthors;
//    }
//
//    //---------------Сохранение автора
//    @PostMapping("/authors")
//    @Secured("ADMIN")
//    public void saveAuthor(Authors author) {
//        authorsService.saveAuthors(author);
//    }
//
//
//    @GetMapping("/clients")
//    public List<Client> showAllClients() {
//        List<Client> allClients = clientService.getAllClients();
//        return allClients;
//    }
//
//    @PutMapping("/clients")
//    public Client updateClient(@RequestBody Client client) {
//        clientService.saveClient(client);
//        return client;
//    }
//
//    @GetMapping("/orders")
//    public List<Order> showAllOrder() {
//        List<Order> allOrder = orderService.getAllOrder();
//        return allOrder;
//    }
//
//
//    @GetMapping("/orders/")
//    public List<Order> showAllOrder(@RequestParam("clientID") int id) {
//        List<Order> allOrder = orderService.getAllOrder();
//        List<Order> orderClient = new ArrayList<>();
//        for (Order o: allOrder) {
//           if (o.getClient().getClientID()==id) {
//               orderClient.add(o);
//           }
//        }
//        return orderClient;
//    }
//
//
//}
