package az.parvin.searching.mapper;

import az.parvin.searching.dto.request.StudentRequest;
import az.parvin.searching.dto.response.StudentResponse;
import az.parvin.searching.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequest request);

    StudentResponse toResponse(Student student);
}
