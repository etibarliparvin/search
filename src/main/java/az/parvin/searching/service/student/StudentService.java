package az.parvin.searching.service.student;

import az.parvin.searching.exception.common.CommonResponse;
import az.parvin.searching.search.student.SearchFilter;

public interface StudentService {

    CommonResponse search(SearchFilter filter);
}
