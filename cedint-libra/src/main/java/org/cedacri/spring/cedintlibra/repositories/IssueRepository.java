package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.entity.Issue;
import org.cedacri.spring.cedintlibra.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    Integer countIssueByStatus_Status(String status);
}
