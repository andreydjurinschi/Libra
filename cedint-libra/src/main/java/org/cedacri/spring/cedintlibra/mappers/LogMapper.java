package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.log.LogBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.log.LogCreateUpdateDto;
import org.cedacri.spring.cedintlibra.entity.Log;

public class LogMapper {

    public static LogBaseDto mapToBaseDto(Log log) {
        return new LogBaseDto(
                log.getId(),
                log.getIssue() != null ? log.getIssue().getId() : null,
                log.getUser() != null ? log.getUser().getId() : null,
                log.getAction(),
                log.getNotes(),
                log.getInsertDate()
        );
    }

    /**
     * issue/user sunt setate în service (după lookup în DB)
     */
    public static Log mapCreateUpdateDtoToEntity(LogCreateUpdateDto dto) {
        Log log = new Log();
        log.setAction(dto.getAction());
        log.setNotes(dto.getNotes());
        log.setInsertDate(dto.getInsertDate());
        return log;
    }

    public static void mapUpdateDtoToExistingEntity(Log existing, LogCreateUpdateDto dto) {
        existing.setAction(dto.getAction());
        existing.setNotes(dto.getNotes());
        existing.setInsertDate(dto.getInsertDate());
    }
}
