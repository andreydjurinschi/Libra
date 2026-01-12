package org.cedacri.spring.cedintlibra.dto_s.connection_type;

public class ConnectionTypeDto {
    private Long id;
    private String connectionType;

    public ConnectionTypeDto(Long id, String connectionType) {
        this.id = id;
        this.connectionType = connectionType;
    }
    public Long getId() { return id; }
    public String getConnectionType() { return connectionType; }
}
