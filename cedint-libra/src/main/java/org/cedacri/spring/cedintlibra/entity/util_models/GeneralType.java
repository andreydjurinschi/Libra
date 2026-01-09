package org.cedacri.spring.cedintlibra.entity.util_models;

public enum GeneralType {
    CONNECTION_ISSUE, // failure with server connection
    HARDWARE_FAILURE, // failure with hardware item (terminal, printer) <- ???
    SOFTWARE_ERROR,
    PAYMENT_DECLINED,
    SYNC_ERROR, // database problem
    PERMISSION_DENIED,
    TIMEOUT,
    UNKNOWN_ERROR
}
