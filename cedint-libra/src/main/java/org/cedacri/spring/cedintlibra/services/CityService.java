package org.cedacri.spring.cedintlibra.services;

import org.cedacri.spring.cedintlibra.dto_s.city.CityCreateUpdateDto;
import org.cedacri.spring.cedintlibra.entity.City;
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

    public City create(CityCreateUpdateDto dto) {
        City city = new City();
        city.setCityName(dto.getName()); // entity field is cityName :contentReference[oaicite:1]{index=1}
        return cityRepository.save(city);
    }

    public City update(Long id, CityCreateUpdateDto dto) {
        City city = getById(id);
        city.setCityName(dto.getName());
        return cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public City getById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public void delete(Long id) {
        cityRepository.delete(getById(id));
    }
}

