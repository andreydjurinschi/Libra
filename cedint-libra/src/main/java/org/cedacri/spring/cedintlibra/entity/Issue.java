package org.cedacri.spring.cedintlibra.entity;

import jakarta.persistence.*;
import org.cedacri.spring.cedintlibra.entity.util_models.GeneralType;

import java.time.LocalDate;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pos", nullable = false)
    private Pos pos;

    @Enumerated(EnumType.STRING)
    private GeneralType generalType;

    private String problemTitle;

    @Column(nullable = false)
    private Integer priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_created", nullable = false)
    private User userCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_assigned")
    private User assigned;

    private String description;
    private LocalDate assignedDate;

    private LocalDate creationDate;
    private LocalDate modifyDate;

    private String solution;

    public Issue() {}

    public Long getId() {
        return id;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

/*
    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }
*/


    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String idProblem) {
        this.problemTitle = idProblem;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
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

    public GeneralType getGeneralType() {
        return generalType;
    }

    public void setGeneralType(GeneralType generalType) {
        this.generalType = generalType;
    }
}
