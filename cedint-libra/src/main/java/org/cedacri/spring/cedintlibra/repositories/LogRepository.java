package org.cedacri.spring.cedintlibra.repositories;

import jakarta.persistence.Id;
import org.cedacri.spring.cedintlibra.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Id> {
}
