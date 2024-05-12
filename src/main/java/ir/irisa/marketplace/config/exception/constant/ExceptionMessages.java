package ir.irisa.marketplace.config.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessages {

    RECORD_ALREADY_EXISTS("Record already exists"),
    DATABASE_IO_EXCEPTION("Could not read/write into database"),
    NO_RECORD_FOUND("Record is not found"),
    ;

    private final String message;
}
