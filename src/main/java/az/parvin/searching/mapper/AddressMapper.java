package az.parvin.searching.mapper;

import az.parvin.searching.dto.request.AddressRequest;
import az.parvin.searching.dto.response.AddressResponse;
import az.parvin.searching.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressRequest request);

    AddressResponse toResponse(Address address);
}
