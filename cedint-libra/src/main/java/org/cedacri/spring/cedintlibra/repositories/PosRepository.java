package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.entity.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface PosRepository extends JpaRepository<Pos, Long> { }


