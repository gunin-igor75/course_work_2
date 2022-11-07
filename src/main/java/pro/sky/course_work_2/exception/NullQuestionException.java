package pro.sky.course_work_2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NullQuestionException extends RuntimeException{
    public NullQuestionException() {
    }

    public NullQuestionException(String message) {
        super(message);
    }

    public NullQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullQuestionException(Throwable cause) {
        super(cause);
    }

    public NullQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
