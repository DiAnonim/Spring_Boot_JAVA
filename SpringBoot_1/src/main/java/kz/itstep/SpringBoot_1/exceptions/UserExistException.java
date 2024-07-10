package kz.itstep.SpringBoot_1.exceptions;

public class UserExistException extends Exception {
    public UserExistException(String message) {
        super(message);
    }
}
