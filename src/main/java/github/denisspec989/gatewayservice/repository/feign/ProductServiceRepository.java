package github.denisspec989.gatewayservice.repository.feign;

import github.denisspec989.gatewayservice.models.AzsDto;
import github.denisspec989.gatewayservice.models.PriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "product-service",url ="http://localhost:8089")
public interface ProductServiceRepository {
    @GetMapping("/api/v1/prices/list")
    List<PriceDTO> getPricesOnAzs(@RequestParam("azsId") String azsId);
}
