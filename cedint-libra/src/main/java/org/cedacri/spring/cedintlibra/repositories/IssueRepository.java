package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    Integer countIssueByStatus_Status(String status);

    @Query("""
                select new org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto(
                    p.id,
                    p.name,
                    p.telephone,
                    p.cellphone,
                    p.address,
                    p.model,
                    p.brand,
                    p.insertDate,
                    count(i)
                )
                from Pos p
                left join p.issues i
                group by
                    p.id,
                    p.name,
                    p.telephone,
                    p.cellphone,
                    p.address,
                    p.model,
                    p.brand,
                    p.insertDate
            """)
    List<PosBaseDto> findAllPosWithIssuesCount();

    @Query(nativeQuery = true, value = "select * from ISSUES where ISSUES.ID_STATUS = :statusId")
    List<Issue> getIssueByStatusId(@Param("statusId") Long statusId);
}
