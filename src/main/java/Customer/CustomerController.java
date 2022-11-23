package Customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("customer")
    List<Customer> all(){
        Customer cus = new Customer("Anthony","anabizconcept9@gmail.com");
        return repository.findAll();
    }

    @PostMapping("customer")
    Customer create(@RequestBody Customer newCustomer){
        return repository.save(newCustomer);
    }

    @DeleteMapping("customer/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("customer/{id}")
    Customer getById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundExeption(id));
    }

    @PutMapping("customer/{id}")
    Customer update(@PathVariable Long id, @RequestBody Customer customerToUpdate){
        return repository.findById(id)
                .map( customer -> {
                    customer.setEmail(customerToUpdate.getEmail());
                    customer.setName(customerToUpdate.getName());
                    repository.save(customer);
                    return customer;
                }).orElseGet(() ->{
                    return repository.save(customerToUpdate);
                });
    }
}
