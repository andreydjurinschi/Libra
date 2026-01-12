package org.cedacri.spring.cedintlibra.dto_s.city;

public class CityDto {
    private Long id;
    private String name;

    public CityDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
}
