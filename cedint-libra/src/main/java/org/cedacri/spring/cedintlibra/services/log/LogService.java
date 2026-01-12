package org.cedacri.spring.cedintlibra.services.log;

import org.cedacri.spring.cedintlibra.dto_s.log.LogBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.log.LogCreateUpdateDto;
import org.cedacri.spring.cedintlibra.entity.Issue;
import org.cedacri.spring.cedintlibra.entity.Log;
import org.cedacri.spring.cedintlibra.entity.User;
import org.cedacri.spring.cedintlibra.mappers.LogMapper;
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

    public LogService(LogRepository logRepository, IssueRepository issueRepository, UserRepository userRepository) {
        this.logRepository = logRepository;
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    public LogBaseDto create(LogCreateUpdateDto dto) {
        Log log = LogMapper.mapCreateUpdateDtoToEntity(dto);

        Issue issue = issueRepository.findById(dto.getIssue())
                .orElseThrow(() -> new RuntimeException("Issue not found: " + dto.getIssue()));
        User user = userRepository.findById(dto.getUser())
                .orElseThrow(() -> new RuntimeException("User not found: " + dto.getUser()));

        log.setIssue(issue);
        log.setUser(user);

        return LogMapper.mapToBaseDto(logRepository.save(log));
    }

    public LogBaseDto update(Long id, LogCreateUpdateDto dto) {
        Log log = getEntity(id);

        // update simple fields
        LogMapper.mapUpdateDtoToExistingEntity(log, dto);

        // update relations
        Issue issue = issueRepository.findById(dto.getIssue())
                .orElseThrow(() -> new RuntimeException("Issue not found: " + dto.getIssue()));
        User user = userRepository.findById(dto.getUser())
                .orElseThrow(() -> new RuntimeException("User not found: " + dto.getUser()));

        log.setIssue(issue);
        log.setUser(user);

        return LogMapper.mapToBaseDto(logRepository.save(log));
    }

    @Transactional(readOnly = true)
    public LogBaseDto getById(Long id) {
        return LogMapper.mapToBaseDto(getEntity(id));
    }

    @Transactional(readOnly = true)
    public List<LogBaseDto> getAll() {
        return logRepository.findAll().stream().map(LogMapper::mapToBaseDto).toList();
    }

    public void delete(Long id) {
        logRepository.delete(getEntity(id));
    }

    private Log getEntity(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found: " + id));
    }
}
