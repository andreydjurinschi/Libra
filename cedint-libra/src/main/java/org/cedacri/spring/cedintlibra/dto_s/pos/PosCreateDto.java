package org.cedacri.spring.cedintlibra.dto_s.pos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cedacri.spring.cedintlibra.entity.util_models.WeekDays;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class PosCreateDto {
    @NotBlank(message = "pos name cannot be empty")
    private String name;
    @NotBlank(message = "phone cannot be empty")
    private String telephone;
    @NotBlank(message = "cellphone cannot be empty")
    private String cellphone;
    @NotBlank(message = "address cannot be empty")
    private String address;
    @NotBlank(message = "model cannot be empty")
    private String model;
    @NotBlank(message = "brand cannot be empty")
    private String brand;
    @NotNull(message = "city is required")
    private Long city;
    private Long connectionTypeId;

    @NotNull
    private LocalTime morningOpening;
    @NotNull

    @NotNull
    private LocalTime morningClosing;

    @NotNull
    private LocalTime afternoonOpening;
    @NotNull
    private LocalTime afternoonClosing;
    private Set<WeekDays> daysClosed;
    @NotNull
    private LocalDate insertDate;

    public PosCreateDto(String name, String telephone, String cellphone, String address, String model, String brand, Long city, Long connectionTypeId, LocalTime morningOpening, LocalTime morningClosing, LocalTime afternoonOpening, LocalTime afternoonClosing, Set<WeekDays> daysClosed, LocalDate insertDate) {
        this.name = name;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.model = model;
        this.brand = brand;
        this.city = city;
        this.connectionTypeId = connectionTypeId;
        this.morningOpening = morningOpening;
        this.morningClosing = morningClosing;
        this.afternoonOpening = afternoonOpening;
        this.afternoonClosing = afternoonClosing;
        this.daysClosed = daysClosed;
        this.insertDate = insertDate;
    }

    public PosCreateDto() {
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

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
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
