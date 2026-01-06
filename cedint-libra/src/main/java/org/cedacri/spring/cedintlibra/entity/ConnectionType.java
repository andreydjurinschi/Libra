package org.cedacri.spring.cedintlibra.entity;

@Entity
@Table(name = "connection_types")
public class ConnectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "connection_type", nullable = false)
    private String connectionType;

    public ConnectionType() {}

    public Long getId() {
        return id;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }
}
