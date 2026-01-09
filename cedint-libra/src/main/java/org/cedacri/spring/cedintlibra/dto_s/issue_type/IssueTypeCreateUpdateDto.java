package org.cedacri.spring.cedintlibra.dto_s.issue_type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cedacri.spring.cedintlibra.entity.IssueType;
import org.cedacri.spring.cedintlibra.entity.util_models.GeneralType;
import org.cedacri.spring.cedintlibra.entity.util_models.IssueLevel;

import java.time.LocalDate;

/**
 * create / update dto for {@link IssueType}
 */
public class IssueTypeCreateUpdateDto {

    @NotNull
    private IssueLevel issueLevel;

    @NotNull
    private GeneralType generalIssueType;

    @NotBlank(message = "issue type name is required")
    private String name;
    // can be null
    private LocalDate insertDate;

    public IssueTypeCreateUpdateDto() {
    }

    public IssueLevel getIssueLevel() {
        return issueLevel;
    }

    public void setIssueLevel(IssueLevel issueLevel) {
        this.issueLevel = issueLevel;
    }

    public GeneralType getGeneralIssueType() {
        return generalIssueType;
    }

    public void setGeneralIssueType(GeneralType generalIssueType) {
        this.generalIssueType = generalIssueType;
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
