package kz.itstep.SpringBoot_1.exceptions;

import java.time.LocalDateTime;

public class UserExistException extends Exception {
    private LocalDateTime localeDateTime;
    public UserExistException(String message) {
        super(message);
    }
}
