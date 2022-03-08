package az.parvin.searching.dto.response;

import lombok.Data;

@Data
public class AddressResponse {
    private Long id;
    private String country;
    private String city;
    private String addressLine;
}
