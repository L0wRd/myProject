package com.hxf;

import com.hxf.myautoconfigure.HelloService;
import com.hxf.pojo.Customer;
//import com.hxf.repository.CustomerJpaRepository;
import com.hxf.repository.CustomerMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: hxf
 * @date: 2019/9/12 14:11
 * @Description:
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

//    @Autowired
//    private CustomerMongoRepository repository;

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        repository.deleteAll();
//        repository.save(new Customer("Alice", "Smith"));
//        repository.save(new Customer("Bob", "Smith"));
//        log.info("Customers found with findAll()");
//        log.info("------------------------------");
//        for (Customer customer : repository.findAll()) {
//            log.info(customer.toString());
//        }
//        log.info("");
//
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Customer customer : repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }
//        System.out.println("//////////////////////////////////////////////////////");
        System.out.println(helloService.sayHello());
    }

    //    @Bean
//    public CommandLineRunner demo(CustomerJpaRepository repository) {
//        return (args )-> {
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "Brain"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//
//            log.info("Customers found with findAll()");
//            log.info("------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            repository.findById(1L).ifPresent(customer -> {
//                log.info("Customer found with findByLastName('Bauer'):");
//                log.info("------------------------------------------");
//                log.info(customer.toString());
//                log.info("");
//            });
//
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("---------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            // 	log.info(bauer.toString());
//            // }
//            log.info("");
//
//        };
//    }
}
