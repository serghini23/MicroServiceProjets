package net.serghini.tpprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TpProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpProjetApplication.class, args);
    }

}
