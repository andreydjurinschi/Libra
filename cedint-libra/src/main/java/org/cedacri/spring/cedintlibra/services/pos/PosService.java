package org.cedacri.spring.cedintlibra.services.pos;

import jakarta.transaction.Transactional;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosCreateDto;
import org.cedacri.spring.cedintlibra.mappers.PosMapper;
import org.cedacri.spring.cedintlibra.entity.City;
import org.cedacri.spring.cedintlibra.entity.ConnectionType;
import org.cedacri.spring.cedintlibra.entity.Pos;
import org.cedacri.spring.cedintlibra.repositories.CityRepository;
import org.cedacri.spring.cedintlibra.repositories.ConnectionTypeRepository;
import org.cedacri.spring.cedintlibra.repositories.PosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PosService {
    private final PosRepository posRepository;

    private final CityRepository cityRepository;
    private final ConnectionTypeRepository connectionTypeRepository;

    public PosService(PosRepository posRepository, CityRepository cityRepository, ConnectionTypeRepository connectionTypeRepository) {
        this.posRepository = posRepository;
        this.cityRepository = cityRepository;
        this.connectionTypeRepository = connectionTypeRepository;
    }

    public List<PosBaseDto> findAll(){
        List<Pos> posList = posRepository.findAll();
        return posList.stream().map(PosMapper::mapToBaseDto).toList();
    }

    public PosBaseDto findById(Long id){
        Pos pos = getPos(id);
        return PosMapper.mapToBaseDto(pos);
    }

    @Transactional
    public void createPos(PosCreateDto dto){
        Pos pos = PosMapper.mapCreatePosDtoToEntity(dto);
        City city = cityRepository.findById(dto.getCity())
                .orElseThrow(() -> new NoSuchElementException("City not found"));
        pos.setCity(city);
        ConnectionType connectionType = connectionTypeRepository.findById(dto.getConnectionTypeId())
                .orElseThrow(() -> new NoSuchElementException("Connection type not found"));
        posRepository.save(pos);
    }


    @Transactional
    public void updatePos(Long id, PosCreateDto dto) {
        Pos pos = getPos(id);
        pos.setName(dto.getName());
        pos.setTelephone(dto.getTelephone());
        pos.setCellphone(dto.getCellphone());
        pos.setAddress(dto.getAddress());
        pos.setModel(dto.getModel());
        pos.setBrand(dto.getBrand());

        City city = cityRepository.findById(dto.getCity())
                .orElseThrow(() -> new NoSuchElementException("City not found"));
        pos.setCity(city);

        ConnectionType connectionType = connectionTypeRepository.findById(dto.getConnectionTypeId())
                    .orElseThrow(() -> new NoSuchElementException("Connection type not found"));

        pos.setConnectionType(connectionType);
        pos.setMorningOpening(dto.getMorningOpening());
        pos.setMorningClosing(dto.getMorningClosing());
        pos.setAfternoonOpening(dto.getAfternoonOpening());
        pos.setAfternoonClosing(dto.getAfternoonClosing());
        pos.setDaysClosed(dto.getDaysClosed());
        pos.setInsertDate(dto.getInsertDate());

        posRepository.save(pos);
    }

    @Transactional
    public void deletePos(Long id){
        Pos pos = getPos(id);
        posRepository.delete(pos);
    }

    private Pos getPos(Long id) {
        return posRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("POS with id " + id + " not found"));
    }
}
