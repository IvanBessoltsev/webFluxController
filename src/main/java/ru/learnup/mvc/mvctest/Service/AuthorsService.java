package ru.learnup.mvc.mvctest.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.mvc.mvctest.entity.Authors;
import ru.learnup.mvc.mvctest.repository.AuthorsRepository;


import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;


    public List<Authors> getAllAuthors() {
        return authorsRepository.findAll();
    }

    public Authors getAuthorsById(int id) {
        Authors author = null;
        Optional<Authors> a = authorsRepository.findById(id);
        if (a.isPresent()) {
            author = a.get();
        }
        return author;
    }

    public void saveAuthors(Authors authors) {
        authorsRepository.save(authors);
    }

    public void deleteAuthor(int id) {
        authorsRepository.deleteById(id);
    }
}
