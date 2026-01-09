package org.cedacri.spring.cedintlibra.services.status;

import org.cedacri.spring.cedintlibra.dto_s.status.StatusDto;
import org.cedacri.spring.cedintlibra.entity.Status;
import org.cedacri.spring.cedintlibra.mappers.StatusMapper;
import org.cedacri.spring.cedintlibra.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<StatusDto> getAll(){
        return statusRepository.findAll().stream().map(StatusMapper::mapToDto).toList();
    }

    public StatusDto getById(Long id){
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("this status does not exist"));
        return StatusMapper.mapToDto(status);
    }
}
