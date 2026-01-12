package org.cedacri.spring.cedintlibra.services.connection_type;

import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeDto;
import org.cedacri.spring.cedintlibra.entity.ConnectionType;
import org.cedacri.spring.cedintlibra.mappers.ConnectionTypeMapper;
import org.cedacri.spring.cedintlibra.repositories.ConnectionTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConnectionTypeService {

    private final ConnectionTypeRepository connectionTypeRepository;

    public ConnectionTypeService(ConnectionTypeRepository connectionTypeRepository) {
        this.connectionTypeRepository = connectionTypeRepository;
    }

    public ConnectionTypeDto create(ConnectionTypeCreateUpdateDto dto) {
        ConnectionType ct = ConnectionTypeMapper.mapCreateUpdateDtoToEntity(dto);
        return ConnectionTypeMapper.mapToDto(connectionTypeRepository.save(ct));
    }

    public ConnectionTypeDto update(Long id, ConnectionTypeCreateUpdateDto dto) {
        ConnectionType ct = getEntity(id);
        ConnectionTypeMapper.mapUpdateDtoToExistingEntity(ct, dto);
        return ConnectionTypeMapper.mapToDto(connectionTypeRepository.save(ct));
    }

    @Transactional(readOnly = true)
    public ConnectionTypeDto getById(Long id) {
        return ConnectionTypeMapper.mapToDto(getEntity(id));
    }

    @Transactional(readOnly = true)
    public List<ConnectionTypeDto> getAll() {
        return connectionTypeRepository.findAll().stream().map(ConnectionTypeMapper::mapToDto).toList();
    }

    public void delete(Long id) {
        connectionTypeRepository.delete(getEntity(id));
    }

    private ConnectionType getEntity(Long id) {
        return connectionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConnectionType not found: " + id));
    }
}
