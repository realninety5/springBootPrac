package com.eplat.web.model;


import com.eplat.web.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UserCLR implements CommandLineRunner {
    private static final Logger log = LoggerFactory
            .getLogger(UserCLR.class);
    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... args) {
        // save a couple of customers
        repo.save(new UserModel("Ranga", 20, false));
        repo.save(new UserModel("Ravi", 30, true));
        repo.save(new UserModel("Satish", 33, false));
        repo.save(new UserModel("Raghu", 25, true));


//        log.info("-------------------------------");
//        log.info("Finding all users");
//        log.info("-------------------------------");
//        for (UserModel user : repo.findAll()) {
//            log.info(user.toString());
//        }
//        log.info("-------------------------------");
//        log.info("Finding all married users");
//        log.info("-------------------------------");
//        for (UserModel user : repo.findByMarried(true)) {
//            log.info(user.toString());
//        }
//        log.info("-------------------------------");
//        log.info("Finding all married users");
//        log.info("-------------------------------");
//        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
//        for (UserModel user : repo.findAll((java.awt.print.Pageable) firstPageWithTwoElements)) {
//            log.info(user.toString());
//        }
    }
}
