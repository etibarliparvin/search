package az.parvin.searching.mapper;

import az.parvin.searching.dto.request.TeacherRequest;
import az.parvin.searching.dto.response.TeacherResponse;
import az.parvin.searching.entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher toEntity(TeacherRequest request);

    TeacherResponse toResponse(Teacher teacher);
}
