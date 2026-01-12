package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeDto;
import org.cedacri.spring.cedintlibra.entity.IssueType;

import java.time.LocalDate;

public class IssueTypeMapper {

    public static IssueTypeDto mapToDto(IssueType it) {
        return new IssueTypeDto(it.getId(), it.getIssueLevel(), it.getGeneralIssueType(), it.getName(), it.getInsertDate());
    }

    public static IssueType mapCreateUpdateDtoToEntity(IssueTypeCreateUpdateDto dto) {
        IssueType it = new IssueType();
        it.setIssueLevel(dto.getIssueLevel());
        it.setGeneralIssueType(dto.getGeneralIssueType());
        it.setName(dto.getName());
        it.setInsertDate(dto.getInsertDate() != null ? dto.getInsertDate() : LocalDate.now());
        return it;
    }

    public static void mapUpdateDtoToExistingEntity(IssueType existing, IssueTypeCreateUpdateDto dto) {
        existing.setIssueLevel(dto.getIssueLevel());
        existing.setGeneralIssueType(dto.getGeneralIssueType());
        existing.setName(dto.getName());
        if (dto.getInsertDate() != null) existing.setInsertDate(dto.getInsertDate());
    }
}
