package az.parvin.searching.mapper;

import az.parvin.searching.dto.request.BookRequest;
import az.parvin.searching.dto.response.BookResponse;
import az.parvin.searching.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

//    @Mapping(source = "id", target = "student.id")
    Book toEntity(BookRequest request);

    BookResponse toResponse(Book book);
}
