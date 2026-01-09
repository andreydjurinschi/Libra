package org.cedacri.spring.cedintlibra.entity;

import jakarta.persistence.*;
import org.cedacri.spring.cedintlibra.entity.util_models.WeekDays;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pos")
public class Pos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String telephone;
    @Column(nullable = false)
    private String cellphone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conn_type", nullable = false)
    private ConnectionType connectionType;

    @Column(nullable = false)
    private LocalTime morningOpening;
    @Column(nullable = false)
    private LocalTime morningClosing;
    @Column(nullable = false)
    private LocalTime afternoonOpening;
    @Column(nullable = false)
    private LocalTime afternoonClosing;
    @Enumerated(EnumType.STRING)
    private Set<WeekDays> daysClosed = new HashSet<>();
    private LocalDate insertDate;

    public Pos() {}

    public Pos(String name, String telephone, String cellphone, String address, String model, String brand, City city, ConnectionType connectionType, LocalTime morningOpening, LocalTime morningClosing, LocalTime afternoonOpening, LocalTime afternoonClosing, Set<WeekDays> daysClosed, LocalDate insertDate) {
        this.name = name;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.address = address;
        this.model = model;
        this.brand = brand;
        this.city = city;
        this.connectionType = connectionType;
        this.morningOpening = morningOpening;
        this.morningClosing = morningClosing;
        this.afternoonOpening = afternoonOpening;
        this.afternoonClosing = afternoonClosing;
        this.daysClosed = daysClosed;
        this.insertDate = insertDate;
    }

    public Long getId() {
        return id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
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
