package org.cedacri.spring.cedintlibra.dto_s.pos;

import org.cedacri.spring.cedintlibra.entity.util_models.WeekDays;

import java.time.LocalDate;
import java.util.Set;

public class PosBaseDto {
    private String name;
    private String telephone;
    private String cellphone;
    private String address;
    private String model;
    private String brand;
    //TODO: to place City dto here when it would be ready
    //private CityDto dto;
    //TODO: to place ConnectionType dto here when it would be ready
    //private ConnectionTypeDto  dto;
    private Set<WeekDays> daysClosed;
    private LocalDate insertDate;
    public PosBaseDto(String name, String telephone, String cellphone, String address, String model, String brand, Set<WeekDays> daysClosed, LocalDate insertDate) {
        this.name = name;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.model = model;
        this.brand = brand;
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
