package tech.hidetora.amazingjavadev.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.hidetora.amazingjavadev.repository.CustomerRepository;

/**
 * @author hidetora
 * @version 1.0.0
 * @since 2022/04/18
 */

@Configuration
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);
    private final CustomerRepository repo;

    public ApplicationRunner(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("ApplicationRunner.run()");
        repo.findAll().forEach(customer -> logger.info("Customer: {}", customer));
    }
}
