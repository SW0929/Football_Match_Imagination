package server.kickoff.exception;

import lombok.ToString;

@ToString
public class DuplicationException extends RuntimeException{
    public DuplicationException() {
        super();
    }

    public DuplicationException(String message) {
        super(message);
    }

    public DuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationException(Throwable cause) {
        super(cause);
    }
}
