package tech.hidetora.amazingjavadev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hidetora.amazingjavadev.entity.Customer;
import tech.hidetora.amazingjavadev.repository.CustomerRepository;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hidetora
 * @version 1.0.0
 * @since 2022/04/18
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    ResponseEntity<?> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{keyword}")
    ResponseEntity<?> searchCustomerByName(@PathVariable String keyword) {
        Iterable<Customer> customers = customerRepository.findByNameContainingIgnoreCase(keyword);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/count")
    ResponseEntity<?> countCustomers() {
        long count = customerRepository.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PostMapping("/save")
    ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        if (customerRepository.existsById(id)) {
            AtomicReference<Customer> save = new AtomicReference<>();
            customerRepository.findById(id).ifPresent(c -> {
                new Customer(id, customer.name());
                save.set(customerRepository.save(c));
            });
            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }
}
