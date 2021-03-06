package finki.emt.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException{
    public BookNotFound(String message) {
        super("Book with id " + message + " not found");
    }
}
