package br.com.ferracini.springfundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringFundamentalsApplication {
    static Logger logger = LoggerFactory.getLogger(SpringFundamentalsApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
    }

}
