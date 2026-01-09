package org.cedacri.spring.cedintlibra.repositories;

import org.cedacri.spring.cedintlibra.entity.IssueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueTypeRepository extends JpaRepository<IssueType, Long> {
}
