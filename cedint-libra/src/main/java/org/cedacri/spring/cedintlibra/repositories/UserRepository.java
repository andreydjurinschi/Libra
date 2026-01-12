package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.dto_s.user.UserWithTypeDto;
import org.cedacri.spring.cedintlibra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from USERS u " +
            "left join USER_TYPES us on us.ID = u.ID_USER_TYPE " +
            "where u.ID = :user_id", nativeQuery = true)
    UserWithTypeDto getUserWithType(@Param("user_id") Long user_id);
}
