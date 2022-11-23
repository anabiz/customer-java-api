package Customer;

public class CustomerNotFoundExeption extends RuntimeException{
    public CustomerNotFoundExeption(Long id) {
        super(String.format("User with id %s not found", id));
    }
}
