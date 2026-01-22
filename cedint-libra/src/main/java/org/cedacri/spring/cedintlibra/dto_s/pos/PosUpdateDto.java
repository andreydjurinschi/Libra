package org.cedacri.spring.cedintlibra.dto_s.pos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.PastOrPresent;
import org.cedacri.spring.cedintlibra.entity.util_models.WeekDays;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class PosUpdateDto {
    private String name;
    private String telephone;
    private String cellphone;
    private String address;
    private String model;
    private String brand;
    private Long cityId;
    private Long connectionTypeId;
    @PastOrPresent
    private LocalTime morningOpening;
    @FutureOrPresent
    private LocalTime morningClosing;
    @FutureOrPresent
    private LocalTime afternoonOpening;
    @FutureOrPresent
    private LocalTime afternoonClosing;
    private Set<WeekDays> daysClosed;
    private LocalDate insertDate;

    public PosUpdateDto() {
    }

    public PosUpdateDto(String name, String telephone, String cellphone, String address, String model, String brand, Long cityId, Long connectionTypeId, LocalTime morningOpening, LocalTime morningClosing, LocalTime afternoonOpening, LocalTime afternoonClosing, Set<WeekDays> daysClosed, LocalDate insertDate) {
        this.name = name;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.model = model;
        this.brand = brand;
        this.cityId = cityId;
        this.connectionTypeId = connectionTypeId;
        this.morningOpening = morningOpening;
        this.morningClosing = morningClosing;
        this.afternoonOpening = afternoonOpening;
        this.afternoonClosing = afternoonClosing;
        this.daysClosed = daysClosed;
        this.insertDate = insertDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getConnectionTypeId() {
        return connectionTypeId;
    }

    public void setConnectionTypeId(Long connectionTypeId) {
        this.connectionTypeId = connectionTypeId;
    }

    public LocalTime getMorningOpening() {
        return morningOpening;
    }

    public void setMorningOpening(LocalTime morningOpening) {
        this.morningOpening = morningOpening;
    }

    public LocalTime getMorningClosing() {
        return morningClosing;
    }

    public void setMorningClosing(LocalTime morningClosing) {
        this.morningClosing = morningClosing;
    }

    public LocalTime getAfternoonOpening() {
        return afternoonOpening;
    }

    public void setAfternoonOpening(LocalTime afternoonOpening) {
        this.afternoonOpening = afternoonOpening;
    }

    public LocalTime getAfternoonClosing() {
        return afternoonClosing;
    }

    public void setAfternoonClosing(LocalTime afternoonClosing) {
        this.afternoonClosing = afternoonClosing;
    }

    public Set<WeekDays> getDaysClosed() {
        return daysClosed;
    }

    public void setDaysClosed(Set<WeekDays> daysClosed) {
        this.daysClosed = daysClosed;
    }

    public LocalDate getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDate insertDate) {
        this.insertDate = insertDate;
    }
}
