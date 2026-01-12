package org.cedacri.spring.cedintlibra.dto_s.log;

import java.time.LocalDate;

public class LogBaseDto {

    private Long id;
    private Long issueId;
    private Long userId;
    private String action;
    private String notes;
    private LocalDate insertDate;

    public LogBaseDto() {
    }

    public LogBaseDto(Long id, Long issueId, Long userId, String action, String notes, LocalDate insertDate) {
        this.id = id;
        this.issueId = issueId;
        this.userId = userId;
        this.action = action;
        this.notes = notes;
        this.insertDate = insertDate;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }
}
