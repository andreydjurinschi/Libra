package org.cedacri.spring.cedintlibra.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "issue_types")
public class IssueType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueLevel;
    private String parentIssue;
    private String name;

    private LocalDate insertDate;

    public IssueType() {}

    public Long getId() {
        return id;
    }

    public String getIssueLevel() {
        return issueLevel;
    }

    public void setIssueLevel(String issueLevel) {
        this.issueLevel = issueLevel;
    }

    public String getParentIssue() {
        return parentIssue;
    }

    public void setParentIssue(String parentIssue) {
        this.parentIssue = parentIssue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }
}

