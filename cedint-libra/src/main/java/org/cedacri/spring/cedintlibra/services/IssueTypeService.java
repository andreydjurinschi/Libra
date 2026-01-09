package org.cedacri.spring.cedintlibra.services;

import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.entity.IssueType;
import org.cedacri.spring.cedintlibra.repositories.IssueTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class IssueTypeService {

    private final IssueTypeRepository issueTypeRepository;

    public IssueTypeService(IssueTypeRepository issueTypeRepository) {
        this.issueTypeRepository = issueTypeRepository;
    }

    public IssueType create(IssueTypeCreateUpdateDto dto) {
        IssueType it = new IssueType(); // has issueLevel, generalIssueType, name, insertDate :contentReference[oaicite:3]{index=3}
        it.setIssueLevel(dto.getIssueLevel());
        it.setGeneralIssueType(dto.getGeneralIssueType());
        it.setName(dto.getName());
        it.setInsertDate(dto.getInsertDate() != null ? dto.getInsertDate() : LocalDate.now());
        return issueTypeRepository.save(it);
    }

    public IssueType update(Long id, IssueTypeCreateUpdateDto dto) {
        IssueType it = getById(id);
        it.setIssueLevel(dto.getIssueLevel());
        it.setGeneralIssueType(dto.getGeneralIssueType());
        it.setName(dto.getName());
        if (dto.getInsertDate() != null) it.setInsertDate(dto.getInsertDate());
        return issueTypeRepository.save(it);
    }

    @Transactional(readOnly = true)
    public IssueType getById(Long id) {
        return issueTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IssueType not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<IssueType> getAll() {
        return issueTypeRepository.findAll();
    }

    public void delete(Long id) {
        issueTypeRepository.delete(getById(id));
    }
}
