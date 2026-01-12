package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.issue.IssueBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueUpdateDto;
import org.cedacri.spring.cedintlibra.entity.Issue;

public class IssueMapper {

    public static IssueBaseDto mapToBaseDto(Issue issue) {
        return new IssueBaseDto(
                issue.getId(),
                issue.getPos() != null ? issue.getPos().getId() : null,
                issue.getType() != null ? issue.getType().getId() : null,
                issue.getGeneralType(),
                issue.getProblemTitle(),
                issue.getPriority(),
                issue.getStatus() != null ? issue.getStatus().getId() : null,
                issue.getMemo(),
                issue.getUserCreated() != null ? issue.getUserCreated().getId() : null,
                issue.getAssigned() != null ? issue.getAssigned().getId() : null,
                issue.getDescription(),
                issue.getAssignedDate(),
                issue.getCreationDate(),
                issue.getModifyDate(),
                issue.getSolution()
        );
    }

    /**
     * pos/type/status/userCreated/assigned sunt setate în service (după lookup în DB)
     */
    public static Issue mapCreateDtoToEntity(IssueCreateDto dto) {
        Issue issue = new Issue();
        issue.setGeneralType(dto.getGeneralType());
        issue.setProblemTitle(dto.getProblemTitle());
        issue.setPriority(dto.getPriority());
        issue.setMemo(dto.getMemo());
        issue.setDescription(dto.getDescription());
        issue.setAssignedDate(dto.getAssignedDate());
        issue.setCreationDate(dto.getCreationDate());
        issue.setModifyDate(dto.getModifyDate());
        issue.setSolution(dto.getSolution());
        return issue;
    }

    /**
     * Update: modificăm doar câmpurile care vin (nu forțăm tot)
     */
    public static void mapUpdateDtoToExistingEntity(Issue existing, IssueUpdateDto dto) {
        if (dto.getGeneralType() != null) existing.setGeneralType(dto.getGeneralType());
        if (dto.getProblemTitle() != null) existing.setProblemTitle(dto.getProblemTitle());
        if (dto.getPriority() != null) existing.setPriority(dto.getPriority());
        if (dto.getMemo() != null) existing.setMemo(dto.getMemo());
        if (dto.getDescription() != null) existing.setDescription(dto.getDescription());
        if (dto.getAssignedDate() != null) existing.setAssignedDate(dto.getAssignedDate());
        if (dto.getCreationDate() != null) existing.setCreationDate(dto.getCreationDate());
        if (dto.getModifyDate() != null) existing.setModifyDate(dto.getModifyDate());
        if (dto.getSolution() != null) existing.setSolution(dto.getSolution());
    }
}
