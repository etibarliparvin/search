package az.parvin.searching.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDetailResponse {
    private Long id;
    private String name;
    private String surname;
    private String grade;
    private String gender;
    List<StudentResponse> students;
}
