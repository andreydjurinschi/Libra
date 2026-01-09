package org.cedacri.spring.cedintlibra.services;

import org.cedacri.spring.cedintlibra.dto_s.log.LogCreateUpdateDto;
import org.cedacri.spring.cedintlibra.entity.Issue;
import org.cedacri.spring.cedintlibra.entity.Log;
import org.cedacri.spring.cedintlibra.entity.User;
import org.cedacri.spring.cedintlibra.repositories.IssueRepository;
import org.cedacri.spring.cedintlibra.repositories.LogRepository;
import org.cedacri.spring.cedintlibra.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogService {

    private final LogRepository logRepository;
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    public LogService(LogRepository logRepository,
                      IssueRepository issueRepository,
                      UserRepository userRepository) {
        this.logRepository = logRepository;
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    public Log create(LogCreateUpdateDto dto) {
        Log log = new Log();
        applyDto(log, dto);
        return logRepository.save(log);
    }

    public Log update(Long id, LogCreateUpdateDto dto) {
        Log log = getById(id);
        applyDto(log, dto);
        return logRepository.save(log);
    }

    private void applyDto(Log log, LogCreateUpdateDto dto) {
        Issue issue = issueRepository.findById(dto.getIssue())
                .orElseThrow(() -> new RuntimeException("Issue not found: " + dto.getIssue()));
        User user = userRepository.findById(dto.getUser())
                .orElseThrow(() -> new RuntimeException("User not found: " + dto.getUser()));

        log.setIssue(issue);
        log.setUser(user);
        log.setAction(dto.getAction());
        log.setNotes(dto.getNotes());
        log.setInsertDate(dto.getInsertDate()); // entity requires non-null :contentReference[oaicite:5]{index=5}
    }

    @Transactional(readOnly = true)
    public Log getById(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Log> getAll() {
        return logRepository.findAll();
    }

    public void delete(Long id) {
        logRepository.delete(getById(id));
    }
}
