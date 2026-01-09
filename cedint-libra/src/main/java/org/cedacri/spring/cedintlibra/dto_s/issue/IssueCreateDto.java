package org.cedacri.spring.cedintlibra.dto_s.issue;

import jakarta.validation.constraints.*;
import org.cedacri.spring.cedintlibra.entity.User;
import org.cedacri.spring.cedintlibra.entity.util_models.GeneralType;

import java.time.LocalDate;

public class IssueCreateDto {

    @NotNull(message = "pos is required")
    private Long posId;

    @NotNull(message = "user is required")
    private User userCreated;

    @NotNull(message = "type is required")
    private Long type;

    // priority rate would be between 1 and 5
    @NotNull
    @Min(value = 1, message = "priority rate cannot be lower than 1 (from 1 to 5)")
    @Max(value = 5, message = "priority rate cannot be higher than 5 (from 1 to 5)")
    private Integer priority;

    @NotNull(message = "status is required")
    private Long status;

    // can be null
    private String memo;
    // can be null
    private String description;

    @NotNull
    private GeneralType generalType;

    @NotBlank
    private String problemTitle;

    // can be null
    private Long assignedToId;

    // can be null
    @FutureOrPresent
    private LocalDate assignedDate;

    @NotNull
    @PastOrPresent
    private LocalDate creationDate;

    @FutureOrPresent
    private LocalDate modifyDate;

    // can be null
    private String solution;

    public IssueCreateDto() {
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GeneralType getGeneralType() {
        return generalType;
    }

    public void setGeneralType(GeneralType generalType) {
        this.generalType = generalType;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
