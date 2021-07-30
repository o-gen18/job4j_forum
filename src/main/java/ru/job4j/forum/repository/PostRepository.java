package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.forum.model.Post;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Override
    @Query("SELECT DISTINCT p FROM Post as p JOIN FETCH p.author ORDER BY p.created DESC")
    Iterable<Post> findAll();

    @Override
    @Query("SELECT DISTINCT p FROM Post as p FULL JOIN FETCH p.comments FULL JOIN FETCH p.author "
            + "WHERE p.id = :ID")
    Optional<Post> findById(@Param("ID") Integer id);
}
