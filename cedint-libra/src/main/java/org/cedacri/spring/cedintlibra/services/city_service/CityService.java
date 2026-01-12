package org.cedacri.spring.cedintlibra.services.city_service;

import org.cedacri.spring.cedintlibra.dto_s.city.CityCreateUpdateDto;
import org.cedacri.spring.cedintlibra.dto_s.city.CityDto;
import org.cedacri.spring.cedintlibra.entity.City;
import org.cedacri.spring.cedintlibra.mappers.CityMapper;
import org.cedacri.spring.cedintlibra.repositories.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDto create(CityCreateUpdateDto dto) {
        City city = CityMapper.mapCreateUpdateDtoToEntity(dto);
        return CityMapper.mapToDto(cityRepository.save(city));
    }

    public CityDto update(Long id, CityCreateUpdateDto dto) {
        City city = getEntity(id);
        CityMapper.mapUpdateDtoToExistingEntity(city, dto);
        return CityMapper.mapToDto(cityRepository.save(city));
    }

    @Transactional(readOnly = true)
    public CityDto getById(Long id) {
        return CityMapper.mapToDto(getEntity(id));
    }

    @Transactional(readOnly = true)
    public List<CityDto> getAll() {
        return cityRepository.findAll().stream().map(CityMapper::mapToDto).toList();
    }

    public void delete(Long id) {
        cityRepository.delete(getEntity(id));
    }

    private City getEntity(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found: " + id));
    }
}
