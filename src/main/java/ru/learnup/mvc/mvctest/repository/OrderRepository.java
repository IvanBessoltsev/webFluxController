package ru.learnup.mvc.mvctest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.mvc.mvctest.entity.Order;

import java.util.Optional;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
