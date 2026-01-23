package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.userType where u.login = :login")
    User findByLoginWithType(@Param("login") String login) throws NoSuchElementException;

}
