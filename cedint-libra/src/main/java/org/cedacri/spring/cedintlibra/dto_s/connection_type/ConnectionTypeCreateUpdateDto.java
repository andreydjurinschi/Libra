package org.cedacri.spring.cedintlibra.dto_s.connection_type;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.cedacri.spring.cedintlibra.entity.ConnectionType;

/**
 * class for {@link ConnectionType} create / update methods
 */
public class ConnectionTypeCreateUpdateDto {

    @NotBlank
    @Size(min = 2, max = 50, message = "connection type name must be between 2 and 50 letters")
    private String connection_type;

    public ConnectionTypeCreateUpdateDto(String connection_type) {
        this.connection_type = connection_type;
    }

    public String getConnection_type() {
        return connection_type;
    }

    public void setConnection_type(String connection_type) {
        this.connection_type = connection_type;
    }
}
