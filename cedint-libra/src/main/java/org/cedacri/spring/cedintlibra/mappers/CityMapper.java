package org.cedacri.spring.cedintlibra.mappers;

import org.cedacri.spring.cedintlibra.dto_s.city.CityCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.city.CityDto;
import org.cedacri.spring.cedintlibra.entity.City;

public class CityMapper {

    public static CityDto mapToDto(City city) {
        return new CityDto(city.getId(), city.getCityName());
    }

    public static City mapCreateUpdateDtoToEntity(CityCreateUpdateDto dto) {
        City city = new City();
        city.setCityName(dto.getName());
        return city;
    }
    public static void mapUpdateDtoToExistingEntity(City existing, CityCreateUpdateDto dto) {
        existing.setCityName(dto.getName());
    }
}

