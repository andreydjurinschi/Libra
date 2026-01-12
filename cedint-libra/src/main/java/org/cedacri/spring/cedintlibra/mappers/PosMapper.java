package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosCreateDto;
import org.cedacri.spring.cedintlibra.entity.Pos;

public class PosMapper {

    public static PosBaseDto mapToBaseDto(Pos pos) {
        return new PosBaseDto(
                pos.getName(),
                pos.getTelephone(),
                pos.getCellphone(),
                pos.getAddress(),
                pos.getModel(),
                pos.getBrand(),
                pos.getDaysClosed(),
                pos.getInsertDate()
                );
    }

    // TODO: replace null on city field
    //  with City entity, replace ConnectionType with ConnectionEntity
    //  when it would be ready
    public static Pos mapCreatePosDtoToEntity(PosCreateDto dto){
        return new Pos(
                dto.getName(),
                dto.getTelephone(),
                dto.getCellphone(),
                dto.getAddress(),
                dto.getModel(),
                dto.getBrand(),
                null /*dto.getCity()*/,
                null /*dto.getConnectionTypeId()*/,
                dto.getMorningOpening(),
                dto.getMorningClosing(),
                dto.getAfternoonOpening(),
                dto.getAfternoonClosing(),
                dto.getDaysClosed(),
                dto.getInsertDate()
        );
    }
}
