package org.cedacri.spring.cedintlibra.services;

import org.cedacri.spring.cedintlibra.dto_s.issue.IssueCreateDto;
import org.cedacri.spring.cedintlibra.entity.*;
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

    public IssueService(
            IssueRepository issueRepository,
            PosRepository posRepository,
            IssueTypeRepository issueTypeRepository,
            StatusRepository statusRepository,
            UserRepository userRepository
    ) {
        this.issueRepository = issueRepository;
        this.posRepository = posRepository;
        this.issueTypeRepository = issueTypeRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    public Issue create(IssueCreateDto dto) {
        Issue issue = new Issue();
        applyDto(issue, dto);
        // dacă nu vrei să trimiți modifyDate la create, o poți seta aici:
        if (issue.getModifyDate() == null) issue.setModifyDate(LocalDate.now());
        return issueRepository.save(issue);
    }

    public Issue update(Long id, IssueCreateDto dto) {
        Issue issue = getById(id);
        applyDto(issue, dto);
        issue.setModifyDate(dto.getModifyDate() != null ? dto.getModifyDate() : LocalDate.now());
        return issueRepository.save(issue);
    }

    private void applyDto(Issue issue, IssueCreateDto dto) {
        // required relations (Issue entity has @ManyToOne pos/type/status/userCreated) :contentReference[oaicite:4]{index=4}
        Pos pos = posRepository.findById(dto.getPosId())
                .orElseThrow(() -> new RuntimeException("POS not found: " + dto.getPosId()));

        IssueType type = issueTypeRepository.findById(dto.getType())
                .orElseThrow(() -> new RuntimeException("IssueType not found: " + dto.getType()));

        Status status = statusRepository.findById(dto.getStatus())
                .orElseThrow(() -> new RuntimeException("Status not found: " + dto.getStatus()));

        if (dto.getUserCreatedId() == null) {
            throw new RuntimeException("userCreatedId is required");
        }
        User userCreated = userRepository.findById(dto.getUserCreatedId())
                .orElseThrow(() -> new RuntimeException("User(created) not found: " + dto.getUserCreatedId()));

        issue.setPos(pos);
        issue.setType(type);
        issue.setStatus(status);
        issue.setUserCreated(userCreated);

        // optional assigned user
        if (dto.getAssignedToId() != null) {
            User assigned = userRepository.findById(dto.getAssignedToId())
                    .orElseThrow(() -> new RuntimeException("User(assigned) not found: " + dto.getAssignedToId()));
            issue.setAssigned(assigned);
        } else {
            issue.setAssigned(null);
        }

        // primitive fields
        issue.setGeneralType(dto.getGeneralType());
        issue.setProblemTitle(dto.getProblemTitle());
        issue.setPriority(dto.getPriority());
        issue.setMemo(dto.getMemo());
        issue.setDescription(dto.getDescription());
        issue.setAssignedDate(dto.getAssignedDate());
        issue.setCreationDate(dto.getCreationDate());
        issue.setModifyDate(dto.getModifyDate());
        issue.setSolution(dto.getSolution());
    }

    @Transactional(readOnly = true)
    public Issue getById(Long id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    public void delete(Long id) {
        issueRepository.delete(getById(id));
    }
}
