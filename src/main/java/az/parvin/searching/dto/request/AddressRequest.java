package az.parvin.searching.dto.request;

import lombok.Data;

@Data
public class AddressRequest {
    private String country;
    private String city;
    private String addressLine;
}
