package server.kickoff.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResult {
    private Date timestamp;
    private String message;
    private String path;
}
