package com.data.rest.Dao;

import com.data.rest.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//If we didn't use this repository then by default the path is books
@RepositoryRestResource(path = "mybooks",collectionResourceRel = "boo")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
