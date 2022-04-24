package finki.emt.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorNotFound extends RuntimeException{
    public AuthorNotFound(String message) {
        super("Author with id " + message + " not found");
    }
}
