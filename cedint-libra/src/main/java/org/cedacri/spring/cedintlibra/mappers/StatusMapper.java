package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.status.StatusDto;
import org.cedacri.spring.cedintlibra.entity.Status;

public class StatusMapper {
    public static StatusDto mapToDto(Status status){
        return new StatusDto(status.getId(), status.getStatus());
    }
}
