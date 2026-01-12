package org.cedacri.spring.cedintlibra.dto_s.issue_type;

import org.cedacri.spring.cedintlibra.entity.util_models.GeneralType;
import org.cedacri.spring.cedintlibra.entity.util_models.IssueLevel;

import java.time.LocalDate;

public class IssueTypeDto {
    private Long id;
    private IssueLevel issueLevel;
    private GeneralType generalIssueType;
    private String name;
    private LocalDate insertDate;

    public IssueTypeDto(Long id, IssueLevel issueLevel, GeneralType generalIssueType, String name, LocalDate insertDate) {
        this.id = id;
        this.issueLevel = issueLevel;
        this.generalIssueType = generalIssueType;
        this.name = name;
        this.insertDate = insertDate;
    }

    public Long getId() { return id; }
    public IssueLevel getIssueLevel() { return issueLevel; }
    public GeneralType getGeneralIssueType() { return generalIssueType; }
    public String getName() { return name; }
    public LocalDate getInsertDate() { return insertDate; }
}
