package ru.learnup.mvc.mvctest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.learnup.mvc.mvctest.Service.AuthorsService;
import ru.learnup.mvc.mvctest.Service.BookService;
import ru.learnup.mvc.mvctest.Service.ClientService;
import ru.learnup.mvc.mvctest.Service.OrderService;
import ru.learnup.mvc.mvctest.entity.Authors;
import ru.learnup.mvc.mvctest.entity.Book;
import ru.learnup.mvc.mvctest.entity.Client;
import ru.learnup.mvc.mvctest.entity.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping({"/api"})
public class RESTController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private JmsTemplate jmsTemplate;



    @JmsListener(destination="superqueue")
    public  void processMessage(String message) {
        log.info("Order:  " + message);
    }

    @GetMapping(value = "/send/{message}", produces = "text/html")
    public String sendMessage(@PathVariable String message) {
        jmsTemplate.convertAndSend("superqueue", message);
        return "done";
    }





    @GetMapping({"/welcome"})
    public String welcome() {
        String w = "HELLO!!! WELCOME!!!";
        return w;
    }

    @GetMapping({"/books"})
    public List<Book> showAllBooks() {
        List<Book> allBooks = this.bookService.getAllBooks();
        return allBooks;
    }

    @GetMapping({"/books/{id}"})
    public Book getBook(@PathVariable int id) {
        Book book = this.bookService.getBookById(id);
        return book;
    }

    @DeleteMapping({"/books/{id}"})
    @Secured("ROLE_ADMIN")
    public void deleteBook(@PathVariable int id) {
       bookService.deleteBook(id);
    }

    @PostMapping({"/books"})
    @Secured("ROLE_ADMIN")
    public void saveBook(@RequestBody Book book) {
       bookService.saveBook(book);
    }

    @DeleteMapping({"/authors/{id}"})
    @Secured("ROLE_ADMIN")
    public void deleteAuthor(@PathVariable int id) {
        authorsService.deleteAuthor(id);
    }

    @GetMapping({"/authors"})
    public List<Authors> showAllAuthors() {
        List<Authors> allAuthors = authorsService.getAllAuthors();
        return allAuthors;
    }

    @PostMapping({"/authors"})
    @Secured("ROLE_ADMIN")
    public void saveAuthor(@RequestBody Authors author) {
        authorsService.saveAuthors(author);
    }

    @GetMapping({"/clients"})
    public List<Client> showAllClients() {
        List<Client> allClients = clientService.getAllClients();
        return allClients;
    }

    @PutMapping({"/clients"})
    public Client updateClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }

    @GetMapping({"/orders"})
    public List<Order> showAllOrder() {
        List<Order> allOrder =orderService.getAllOrder();
        return allOrder;
    }

    @GetMapping({"/orders/"})
    public List<Order> showAllOrder(@RequestParam("clientID") int id) {
        List<Order> allOrder = orderService.getAllOrder();
        List<Order> orderClient = new ArrayList();
        Iterator var4 = allOrder.iterator();

        while (var4.hasNext()) {
            Order o = (Order) var4.next();
            if (o.getClient().getClientID() == (long) id) {
                orderClient.add(o);
            }
        }

        return orderClient;
    }

    @GetMapping({"/orders/client"})
    public List<Order> showByClient(@RequestBody Client client) {
        List<Order> allOrder =orderService.getAllOrder();
        List<Order> orderByClient = new ArrayList<>();
        for (Order o: allOrder) {
            if (o.getClient().getClientID()==client.getClientID()) {
                orderByClient.add(o);
            }
        }
        return orderByClient;
    }


}
