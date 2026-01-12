package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeDto;
import org.cedacri.spring.cedintlibra.entity.ConnectionType;

public class ConnectionTypeMapper {

    public static ConnectionTypeDto mapToDto(ConnectionType ct) {
        return new ConnectionTypeDto(ct.getId(), ct.getConnectionType());
    }

    public static ConnectionType mapCreateUpdateDtoToEntity(ConnectionTypeCreateUpdateDto dto) {
        ConnectionType ct = new ConnectionType();
        ct.setConnectionType(dto.getConnection_type());
        return ct;
    }

    public static void mapUpdateDtoToExistingEntity(ConnectionType existing, ConnectionTypeCreateUpdateDto dto) {
        existing.setConnectionType(dto.getConnection_type());
    }
}

