package az.parvin.searching.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private String author;
    private String name;
    private Integer year;
}
