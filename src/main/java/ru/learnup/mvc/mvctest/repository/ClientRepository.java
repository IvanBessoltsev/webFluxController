package ru.learnup.mvc.mvctest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.mvc.mvctest.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

//    public Client findClientByEmailEquals (String email);


}
