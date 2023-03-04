package github.denisspec989.gatewayservice.repository.feign;

import github.denisspec989.gatewayservice.models.AzsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "azs-service",url ="http://localhost:8088")
public interface AzsServiceRepository {
    @GetMapping("/api/v1/azses/list")
    public List<AzsDto> getFullAzsList();
    @GetMapping("/api/v1/azses/azs")
    public AzsDto getAzsDetail(@RequestParam("azsId")String azsId);
}
