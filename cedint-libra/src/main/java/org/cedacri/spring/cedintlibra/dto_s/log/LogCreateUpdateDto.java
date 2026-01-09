package org.cedacri.spring.cedintlibra.dto_s.log;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cedacri.spring.cedintlibra.entity.Log;

import java.time.LocalDate;

/**
 * create update dto for {@link Log}
 */
public class LogCreateUpdateDto {

    @NotNull
    private Long issue;

    @NotNull
    private Long user;

    @NotBlank(message = "fill action filed pls")
    private String action;
    @NotBlank(message = "fill action notes pls")
    private String notes;
    @NotNull
    private LocalDate insertDate;

    public LogCreateUpdateDto() {
    }

    public Long getIssue() {
        return issue;
    }

    public void setIssue(Long issue) {
        this.issue = issue;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
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
