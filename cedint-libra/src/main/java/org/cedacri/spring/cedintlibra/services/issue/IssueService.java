package org.cedacri.spring.cedintlibra.services.issue;

import org.cedacri.spring.cedintlibra.dto_s.issue.IssueBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueUpdateDto;
import org.cedacri.spring.cedintlibra.entity.*;
import org.cedacri.spring.cedintlibra.mappers.IssueMapper;
import org.cedacri.spring.cedintlibra.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class IssueService {

    private final IssueRepository issueRepository;
    private final PosRepository posRepository;
    private final IssueTypeRepository issueTypeRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;

    public IssueService(IssueRepository issueRepository,
                        PosRepository posRepository,
                        IssueTypeRepository issueTypeRepository,
                        StatusRepository statusRepository,
                        UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.posRepository = posRepository;
        this.issueTypeRepository = issueTypeRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    public IssueBaseDto create(IssueCreateDto dto) {
        if (dto.getUserCreatedId() == null) {
            throw new RuntimeException("userCreatedId is required");
        }

        Issue issue = IssueMapper.mapCreateDtoToEntity(dto);

        // lookup relations (DTO has IDs, entity needs objects)
        issue.setPos(posRepository.findById(dto.getPosId())
                .orElseThrow(() -> new RuntimeException("POS not found: " + dto.getPosId())));

//        issue.setType(issueTypeRepository.findById(dto.getType())
//                .orElseThrow(() -> new RuntimeException("IssueType not found: " + dto.getType())));

        issue.setStatus(statusRepository.findById(dto.getStatus())
                .orElseThrow(() -> new RuntimeException("Status not found: " + dto.getStatus())));

        issue.setUserCreated(userRepository.findById(dto.getUserCreatedId())
                .orElseThrow(() -> new RuntimeException("User(created) not found: " + dto.getUserCreatedId())));

        if (dto.getAssignedToId() != null) {
            issue.setAssigned(userRepository.findById(dto.getAssignedToId())
                    .orElseThrow(() -> new RuntimeException("User(assigned) not found: " + dto.getAssignedToId())));
        }

        if (issue.getModifyDate() == null) {
            issue.setModifyDate(LocalDate.now());
        }

        return IssueMapper.mapToBaseDto(issueRepository.save(issue));
    }

    public IssueBaseDto update(Long id, IssueUpdateDto dto) {
        Issue issue = getEntity(id);

        // update primitive fields
        IssueMapper.mapUpdateDtoToExistingEntity(issue, dto);

        // update relations only if provided
        if (dto.getPosId() != null) {
            issue.setPos(posRepository.findById(dto.getPosId())
                    .orElseThrow(() -> new RuntimeException("POS not found: " + dto.getPosId())));
        }
//        if (dto.getType() != null) {
//            issue.setType(issueTypeRepository.findById(dto.getType())
//                    .orElseThrow(() -> new RuntimeException("IssueType not found: " + dto.getType())));
//        }
        if (dto.getStatus() != null) {
            issue.setStatus(statusRepository.findById(dto.getStatus())
                    .orElseThrow(() -> new RuntimeException("Status not found: " + dto.getStatus())));
        }
        if (dto.getAssignedToId() != null) {
            issue.setAssigned(userRepository.findById(dto.getAssignedToId())
                    .orElseThrow(() -> new RuntimeException("User(assigned) not found: " + dto.getAssignedToId())));
        }

        if (issue.getModifyDate() == null) {
            issue.setModifyDate(LocalDate.now());
        }

        return IssueMapper.mapToBaseDto(issueRepository.save(issue));
    }

    @Transactional(readOnly = true)
    public IssueBaseDto getById(Long id) {
        return IssueMapper.mapToBaseDto(getEntity(id));
    }

    @Transactional(readOnly = true)
    public List<IssueBaseDto> getAll() {
        return issueRepository.findAll().stream().map(IssueMapper::mapToBaseDto).toList();
    }

    public Integer getIssueCountByStatus(String status){
        return issueRepository.countIssueByStatus_Status(status);
    }

    public void delete(Long id) {
        issueRepository.delete(getEntity(id));
    }

    private Issue getEntity(Long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found: " + id));
    }
}
