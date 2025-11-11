package net.serghini.tpprojet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "ChercheurClient", url = "http://localhost:9095")

public interface ChercheurClient {

        @GetMapping("/v1/chercheurs/{id}")
        Object getChercheurById(@PathVariable("id") Long id);
    }

