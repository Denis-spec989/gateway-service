package github.denisspec989.gatewayservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AzsFullDto {
    private String      azsId_company;
    private Double      latitude;
    private Double      longitude;
    private String      telephone;
    private String      azsName;
    private String      azsAddress;
    List<PriceDTO> priceDTOList ;
    List<ServiceDTO> serviceDTOList;
}
