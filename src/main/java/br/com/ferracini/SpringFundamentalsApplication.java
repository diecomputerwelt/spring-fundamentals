package br.com.ferracini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.ferracini.repository")
@ComponentScan(basePackages = {"br.com.ferracini.controller"})
@EntityScan("br.com.ferracini.*")
public class SpringFundamentalsApplication {
    static Logger logger = LoggerFactory.getLogger(SpringFundamentalsApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
    }

}
