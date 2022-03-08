package az.parvin.searching.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String author;
    private String name;
    private Integer year;
}
