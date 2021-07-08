package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    String USER_QUERY = "SELECT DISTINCT u FROM User u FULL JOIN FETCH u.authorities ";

    @Query(USER_QUERY + "FULL JOIN FETCH u.posts WHERE u.username = :NAME")
    User findByUsername(@Param(value = "NAME") String username);

    @Override
    @Query(USER_QUERY)
    Iterable<User> findAll();
}
