package ru.spring4;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface UsersRepo extends CrudRepository<Users,Long> {
    @Query("select u from Users u where u.username =?1")
    Users findByUserName(String name);

}
