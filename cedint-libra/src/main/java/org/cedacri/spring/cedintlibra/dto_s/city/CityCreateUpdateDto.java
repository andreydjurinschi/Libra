package org.cedacri.spring.cedintlibra.dto_s.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.cedacri.spring.cedintlibra.entity.City;

/**
 * class for create {@link City} / update methods
 */
public class CityCreateUpdateDto {

    @NotBlank
    @Size(min = 2, max = 50, message = "city name must be between 2 and 50 letters")
    private String name;

    public CityCreateUpdateDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
