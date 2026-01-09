package org.cedacri.spring.cedintlibra.services;

import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.entity.ConnectionType;
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

    public ConnectionType create(ConnectionTypeCreateUpdateDto dto) {
        ConnectionType ct = new ConnectionType();
        ct.setConnectionType(dto.getConnection_type()); // entity field is connectionType :contentReference[oaicite:2]{index=2}
        return connectionTypeRepository.save(ct);
    }

    public ConnectionType update(Long id, ConnectionTypeCreateUpdateDto dto) {
        ConnectionType ct = getById(id);
        ct.setConnectionType(dto.getConnection_type());
        return connectionTypeRepository.save(ct);
    }

    @Transactional(readOnly = true)
    public ConnectionType getById(Long id) {
        return connectionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConnectionType not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<ConnectionType> getAll() {
        return connectionTypeRepository.findAll();
    }

    public void delete(Long id) {
        connectionTypeRepository.delete(getById(id));
    }
}
