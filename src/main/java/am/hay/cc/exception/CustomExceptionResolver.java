package am.hay.cc.exception;

import am.hay.cc.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@Component
@ControllerAdvice
public class CustomExceptionResolver extends ResponseEntityExceptionHandler {

//    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionResolver.class);

    @ExceptionHandler(RecordNotFoundException.class)
    protected ResponseEntity<ErrorDetails> handleRecordNotFoundException(RecordNotFoundException ex) {
        final ErrorDetails errorDetails = new ErrorDetails(new Date(), "Records not found",
                ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
