package Customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class CustomerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CustomerNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CustomerNotFoundHandler(CustomerNotFoundExeption ex){
        return ex.getMessage();
    }
}
