package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findDistinctByPublishing_PublisherOrPublishing_City(String title, String city);
}
