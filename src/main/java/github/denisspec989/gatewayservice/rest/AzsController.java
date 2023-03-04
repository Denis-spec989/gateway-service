package github.denisspec989.gatewayservice.rest;

import github.denisspec989.gatewayservice.models.AzsDto;
import github.denisspec989.gatewayservice.models.AzsFullDto;
import github.denisspec989.gatewayservice.models.PriceDTO;
import github.denisspec989.gatewayservice.models.ServiceDTO;
import github.denisspec989.gatewayservice.repository.feign.AzsServiceRepository;
import github.denisspec989.gatewayservice.repository.feign.ProductServiceRepository;
import github.denisspec989.gatewayservice.repository.feign.ServicesServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/azses")
@RequiredArgsConstructor
public class AzsController {
    private final AzsServiceRepository azsServiceRepository;
    private final ProductServiceRepository productServiceRepository;
    private final ServicesServiceRepository servicesServiceRepository;

    @GetMapping("/list")
    List<AzsDto> getFullAzsListAsShortDto(){
       return azsServiceRepository.getFullAzsList();
    }
    @GetMapping("/azs/detail")
    AzsFullDto getAzsFullInfo(@RequestParam("azsId")String azsId){
        AzsDto azsDto = azsServiceRepository.getAzsDetail(azsId);
        if(azsDto!=null){
            List<PriceDTO> priceDTOList = productServiceRepository.getPricesOnAzs(azsId);
            List<ServiceDTO> serviceDTOList = servicesServiceRepository.getServicesOnAzs(azsId);
            AzsFullDto azsFullDto = new AzsFullDto();
            azsFullDto.setAzsId_company(azsDto.getAzsId_company());
            azsFullDto.setLatitude(azsDto.getLatitude());
            azsFullDto.setLongitude(azsDto.getLongitude());
            azsFullDto.setTelephone(azsDto.getTelephone());
            azsFullDto.setAzsName(azsDto.getAzsName());
            azsFullDto.setAzsAddress(azsDto.getAzsAddress());
            azsFullDto.setPriceDTOList(priceDTOList);
            azsFullDto.setServiceDTOList(serviceDTOList);
            return azsFullDto;
        }else {
            throw new RuntimeException();
        }
    }
}
