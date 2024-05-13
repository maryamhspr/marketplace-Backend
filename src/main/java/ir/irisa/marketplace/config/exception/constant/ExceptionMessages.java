package ir.irisa.marketplace.config.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessages {

    RECORD_ALREADY_EXISTS("Record already exists"),
    INVALID_ROLE("role field has invalid value.Valid roles id SUPPLIER"),
    DATABASE_IO_EXCEPTION("Could not read/write into database"),
    NO_RECORD_FOUND("Record is not found"),
    ;

    private final String message;
}
