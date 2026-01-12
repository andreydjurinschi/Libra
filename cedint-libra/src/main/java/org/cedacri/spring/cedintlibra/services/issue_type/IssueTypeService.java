package org.cedacri.spring.cedintlibra.services.issue_type;

import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.issue_type.IssueTypeDto;
import org.cedacri.spring.cedintlibra.entity.IssueType;
import org.cedacri.spring.cedintlibra.mappers.IssueTypeMapper;
import org.cedacri.spring.cedintlibra.repositories.IssueTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IssueTypeService {

    private final IssueTypeRepository issueTypeRepository;

    public IssueTypeService(IssueTypeRepository issueTypeRepository) {
        this.issueTypeRepository = issueTypeRepository;
    }

    public IssueTypeDto create(IssueTypeCreateUpdateDto dto) {
        IssueType it = IssueTypeMapper.mapCreateUpdateDtoToEntity(dto);
        return IssueTypeMapper.mapToDto(issueTypeRepository.save(it));
    }

    public IssueTypeDto update(Long id, IssueTypeCreateUpdateDto dto) {
        IssueType it = getEntity(id);
        IssueTypeMapper.mapUpdateDtoToExistingEntity(it, dto);
        return IssueTypeMapper.mapToDto(issueTypeRepository.save(it));
    }

    @Transactional(readOnly = true)
    public IssueTypeDto getById(Long id) {
        return IssueTypeMapper.mapToDto(getEntity(id));
    }

    @Transactional(readOnly = true)
    public List<IssueTypeDto> getAll() {
        return issueTypeRepository.findAll().stream().map(IssueTypeMapper::mapToDto).toList();
    }

    public void delete(Long id) {
        issueTypeRepository.delete(getEntity(id));
    }

    private IssueType getEntity(Long id) {
        return issueTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IssueType not found: " + id));
    }
}
