package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.entity.Issue;
import org.cedacri.spring.cedintlibra.entity.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PosRepository extends JpaRepository<Pos, Long> {
    @Query(nativeQuery = true, value = "select * from ISSUES where ISSUES.ID_POS = :posId")
    List<Issue> getIssuesForPos(@Param("posId") Long posId);
}


