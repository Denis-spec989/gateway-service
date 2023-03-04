package github.denisspec989.gatewayservice.repository.feign;

import github.denisspec989.gatewayservice.models.PriceDTO;
import github.denisspec989.gatewayservice.models.ServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "services-service")
public interface ServicesServiceRepository {
    @GetMapping("/api/v1/services/list")
    List<ServiceDTO> getServicesOnAzs(@RequestParam("azsId") String azsId);
}
