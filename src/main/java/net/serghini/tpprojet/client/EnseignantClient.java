package net.serghini.tpprojet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "EnseignantClient", url = "http://localhost:9090")

public interface EnseignantClient {
    @GetMapping("/v1/enseignants/{id}")
    Object getEnseignantById(@PathVariable("id") Long id);
}
