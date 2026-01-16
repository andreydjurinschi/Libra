package org.cedacri.spring.cedintlibra.dto_s.issue;

import org.cedacri.spring.cedintlibra.entity.util_models.GeneralType;

import java.time.LocalDate;

public class IssueBaseDto {

    private Long id;
    private Long posId;
    private Long typeId;
    private GeneralType generalType;
    private String problemTitle;
    private Integer priority;
    private Long status;
    private String memo;
    private Long userCreatedId;
    private Long assignedToId;
    private String description;
    private LocalDate assignedDate;
    private LocalDate creationDate;
    private LocalDate modifyDate;
    private String solution;

    public IssueBaseDto() {
    }

    public IssueBaseDto(
            Long id,
            Long posId,
            Long typeId,
            GeneralType generalType,
            String problemTitle,
            Integer priority,
            Long status,
            String memo,
            Long userCreatedId,
            Long assignedToId,
            String description,
            LocalDate assignedDate,
            LocalDate creationDate,
            LocalDate modifyDate,
            String solution
    ) {
        this.id = id;
        this.posId = posId;
        this.typeId = typeId;
        this.generalType = generalType;
        this.problemTitle = problemTitle;
        this.priority = priority;
        this.status = status;
        this.memo = memo;
        this.userCreatedId = userCreatedId;
        this.assignedToId = assignedToId;
        this.description = description;
        this.assignedDate = assignedDate;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.solution = solution;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public Long getUserCreatedId() {
        return userCreatedId;
    }

    public void setUserCreatedId(Long userCreatedId) {
        this.userCreatedId = userCreatedId;
    }

    public Long getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Long assignedToId) {
        this.assignedToId = assignedToId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

