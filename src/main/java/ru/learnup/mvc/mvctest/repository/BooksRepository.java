package ru.learnup.mvc.mvctest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.mvc.mvctest.entity.Book;

import java.util.List;


@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

   public  List<Book> findAllByTitleContainsAndPriceEquals(String title, double price);
}
