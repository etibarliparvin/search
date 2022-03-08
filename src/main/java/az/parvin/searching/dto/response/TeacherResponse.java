package az.parvin.searching.dto.response;

import lombok.Data;

@Data
public class TeacherResponse {
    private Long id;
    private String name;
    private String surname;
    private String grade;
    private String gender;
}
