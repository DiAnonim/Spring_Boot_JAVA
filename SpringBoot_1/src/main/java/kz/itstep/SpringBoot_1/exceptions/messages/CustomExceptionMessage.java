package kz.itstep.SpringBoot_1.exceptions.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomExceptionMessage {
    private LocalDateTime timestamp;
    private String message;
    private Integer code;

    public CustomExceptionMessage(LocalDateTime timestamp, String message, Integer code) {
        this.timestamp = timestamp;
        this.message = message;
        this.code = code;
    }
}
