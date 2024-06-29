package web.service.restful.device_management.Models.outputDto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class ConfirmOutputDto {

    private int statusCode;
    private String message;
    private Timestamp timestamp;

    public ConfirmOutputDto(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
