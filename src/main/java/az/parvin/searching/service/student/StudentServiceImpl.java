package az.parvin.searching.service.student;

import az.parvin.searching.exception.common.CommonResponse;
import az.parvin.searching.mapper.StudentMapper;
import az.parvin.searching.repository.StudentRepository;
import az.parvin.searching.search.student.SearchFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public CommonResponse search(SearchFilter filter) {
        return null;
    }
}
