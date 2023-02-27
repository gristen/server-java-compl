package ru.biponline.demo.service;

import org.springframework.stereotype.Service;
import ru.biponline.demo.entity.BookEntity;
import ru.biponline.demo.exception.ValidationException;
import ru.biponline.demo.repo.BookRepo;
import ru.biponline.demo.utils.ValidationUtils;

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo) {
        this.repo=repo;
    }
    public void save(BookEntity book) throws ValidationException {
        ValidationUtils.validateBook(book);
        repo.save(book);
    }
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<BookEntity> getAll(){return repo.findAll();}
}
