package tech.hidetora.amazingjavadev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.hidetora.amazingjavadev.entity.Customer;

/**
 * @author hidetora
 * @version 1.0.0
 * @since 2022/04/18
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findByNameContainingIgnoreCase(String name);
}
