package finki.emt.lab.model.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CountryNotFound extends RuntimeException{

    public CountryNotFound(String message) {
        super("Country with id " + message + " not found");
    }
}
