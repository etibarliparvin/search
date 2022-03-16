package az.parvin.searching.service.student;

import az.parvin.searching.dto.response.StudentResponse;
import az.parvin.searching.entity.Student;
import az.parvin.searching.exception.common.CommonResponse;
import az.parvin.searching.mapper.StudentMapper;
import az.parvin.searching.repository.StudentRepository;
import az.parvin.searching.search.student.SearchFilter;
import az.parvin.searching.search.student.SearchSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public CommonResponse search(SearchFilter filter) {
        CommonResponse response = new CommonResponse();
        SearchSpecification searchSpecification = new SearchSpecification();
        searchSpecification.search(filter);
        List<Student> students = studentRepository.findAll(searchSpecification);
        List<StudentResponse> studentResponse = students.stream().map(studentMapper::toResponse).collect(Collectors.toList());
        response.setItem(studentResponse);
        return response;
    }
}
