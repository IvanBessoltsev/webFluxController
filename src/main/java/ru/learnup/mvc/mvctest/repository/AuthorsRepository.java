package ru.learnup.mvc.mvctest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.mvc.mvctest.entity.Authors;


@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
}
