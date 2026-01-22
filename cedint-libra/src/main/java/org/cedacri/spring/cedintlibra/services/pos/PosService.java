package org.cedacri.spring.cedintlibra.services.pos;

import jakarta.transaction.Transactional;
import org.cedacri.spring.cedintlibra.dto_s.issue.IssueBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosBaseDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosCreateDto;
import org.cedacri.spring.cedintlibra.dto_s.pos.PosDetailedDto;
import org.cedacri.spring.cedintlibra.entity.Issue;
import org.cedacri.spring.cedintlibra.entity.util_models.WeekDays;
import org.cedacri.spring.cedintlibra.mappers.IssueMapper;
import org.cedacri.spring.cedintlibra.mappers.PosMapper;
import org.cedacri.spring.cedintlibra.entity.City;
import org.cedacri.spring.cedintlibra.entity.ConnectionType;
import org.cedacri.spring.cedintlibra.entity.Pos;
import org.cedacri.spring.cedintlibra.repositories.CityRepository;
import org.cedacri.spring.cedintlibra.repositories.ConnectionTypeRepository;
import org.cedacri.spring.cedintlibra.repositories.IssueRepository;
import org.cedacri.spring.cedintlibra.repositories.PosRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@Service
public class PosService {
    private final PosRepository posRepository;
    private final CityRepository cityRepository;
    private final IssueRepository issueRepository;
    private final ConnectionTypeRepository connectionTypeRepository;

    public PosService(PosRepository posRepository, CityRepository cityRepository, ConnectionTypeRepository connectionTypeRepository, IssueRepository issueRepository) {
        this.posRepository = posRepository;
        this.cityRepository = cityRepository;
        this.connectionTypeRepository = connectionTypeRepository;
        this.issueRepository = issueRepository;
    }

    public List<PosBaseDto> findAll(){
        return issueRepository.findAllPosWithIssuesCount();
    }

    public PosBaseDto findById(Long id){
        Pos pos = getPos(id);
        return PosMapper.mapToBaseDto(pos);
    }

    public List<IssueBaseDto> findAllByIssuesByPosId(Long posId){
        List<Issue> issues = posRepository.getIssuesForPos(posId);
        return issues.stream().map(IssueMapper::mapToBaseDto).toList();
    }

    @Transactional
    public void createPos(PosCreateDto dto){
        Pos pos = PosMapper.mapCreatePosDtoToEntity(dto);
        City city = cityRepository.findById(dto.getCity())
                .orElseThrow(() -> new NoSuchElementException("City not found"));
        pos.setCity(city);
        ConnectionType connectionType = connectionTypeRepository.findById(dto.getConnectionTypeId())
                .orElseThrow(() -> new NoSuchElementException("Connection type not found"));
        pos.setConnectionType(connectionType);
        posRepository.save(pos);
    }


    @Transactional
    public void updatePos(Long id, PosCreateDto dto) {

        if (dto == null) {
            throw new IllegalArgumentException("dto cannot be null");
        }

        Pos pos = getPos(id);

        if (!StringUtils.hasText(dto.getName())) {
            throw new IllegalArgumentException("pos name cannot be empty");
        }
        pos.setName(dto.getName().trim());

        if (!StringUtils.hasText(dto.getTelephone())) {
            throw new IllegalArgumentException("phone cannot be empty");
        }
        pos.setTelephone(dto.getTelephone().trim());

        if (!StringUtils.hasText(dto.getCellphone())) {
            throw new IllegalArgumentException("cellphone cannot be empty");
        }
        pos.setCellphone(dto.getCellphone().trim());

        if (!StringUtils.hasText(dto.getAddress())) {
            throw new IllegalArgumentException("address cannot be empty");
        }
        pos.setAddress(dto.getAddress().trim());

        if (!StringUtils.hasText(dto.getModel())) {
            throw new IllegalArgumentException("model cannot be empty");
        }
        pos.setModel(dto.getModel().trim());

        if (!StringUtils.hasText(dto.getBrand())) {
            throw new IllegalArgumentException("brand cannot be empty");
        }
        pos.setBrand(dto.getBrand().trim());

        if (dto.getCity() == null) {
            throw new IllegalArgumentException("city is required");
        }

        City city = cityRepository.findById(dto.getCity())
                .orElseThrow(() -> new NoSuchElementException("City not found"));
        pos.setCity(city);

        if (dto.getConnectionTypeId() != null) {
            ConnectionType connectionType = connectionTypeRepository.findById(dto.getConnectionTypeId())
                    .orElseThrow(() -> new NoSuchElementException("Connection type not found"));
            pos.setConnectionType(connectionType);
        } else {
            pos.setConnectionType(null);
        }

        LocalTime morningOpening = dto.getMorningOpening();
        LocalTime morningClosing = dto.getMorningClosing();
        LocalTime afternoonOpening = dto.getAfternoonOpening();
        LocalTime afternoonClosing = dto.getAfternoonClosing();

        if (!morningOpening.isBefore(morningClosing)) {
            throw new IllegalArgumentException("morning opening must be before morning closing");
        }
        if (!afternoonOpening.isBefore(afternoonClosing)) {
            throw new IllegalArgumentException("afternoon opening must be before afternoon closing");
        }
        pos.setMorningOpening(morningOpening);
        pos.setMorningClosing(morningClosing);
        pos.setAfternoonOpening(afternoonOpening);
        pos.setAfternoonClosing(afternoonClosing);

        Set<WeekDays> daysClosed = dto.getDaysClosed();
        pos.setDaysClosed(Objects.requireNonNullElse(daysClosed, Set.of()));


        if (dto.getInsertDate() == null) {
            throw new IllegalArgumentException("insertDate is required");
        }
        pos.setInsertDate(dto.getInsertDate());


        posRepository.save(pos);
    }

    @Transactional
    public void deletePos(Long id){
        Pos pos = getPos(id);
        posRepository.delete(pos);
    }

    public PosDetailedDto getFullPosData(Long id){
        Pos pos = getPos(id);

        return PosMapper.mapToDetailedDto(pos);
    }
    private Pos getPos(Long id) {
        return posRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("POS with id " + id + " not found"));
    }
}
