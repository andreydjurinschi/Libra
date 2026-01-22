package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.city.CityDto;
import org.cedacri.spring.cedintlibra.dto_s.connection_type.ConnectionTypeDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosDetailedDto;
import org.cedacri.spring.cedintlibra.entity.Pos;

public class PosMapper {

    public static PosBaseDto mapToBaseDto(Pos pos) {
        return new PosBaseDto(
                pos.getId(),
                pos.getName(),
                pos.getTelephone(),
                pos.getCellphone(),
                pos.getAddress(),
                pos.getModel(),
                pos.getBrand()
                ,pos.getInsertDate(),
                null
                );
    }

    public static Pos mapCreatePosDtoToEntity(PosCreateDto dto){
        return new Pos(
                dto.getName(),
                dto.getTelephone(),
                dto.getCellphone(),
                dto.getAddress(),
                dto.getModel(),
                dto.getBrand(),
                null,
                null,
                dto.getMorningOpening(),
                dto.getMorningClosing(),
                dto.getAfternoonOpening(),
                dto.getAfternoonClosing(),
                dto.getDaysClosed(),
                dto.getInsertDate()
        );
    }

    public static PosDetailedDto mapToDetailedDto(Pos pos) {

        CityDto cityDto = CityMapper.mapToDto(pos.getCity());
        ConnectionTypeDto connectionTypeDto = ConnectionTypeMapper.mapToDto(pos.getConnectionType());

        return new PosDetailedDto(
            pos.getName(),
                pos.getTelephone(),
                pos.getCellphone(),
                pos.getAddress(),
                pos.getModel(),
                pos.getBrand(),
                cityDto,
                connectionTypeDto,
                pos.getMorningOpening(),
                pos.getMorningClosing(),
                pos.getAfternoonOpening(),
                pos.getAfternoonClosing(),
                pos.getDaysClosed(),
                pos.getInsertDate()
        );
    }
}
