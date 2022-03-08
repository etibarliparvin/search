package az.parvin.searching.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria<E1, E2> {

    private String key;
    private E1 value1;
    private E2 value2;
    private SearchOperation searchOperation1;
    private SearchOperation searchOperation2;

    public SearchCriteria(String key, E1 value1, SearchOperation searchOperation1) {
        this.key = key;
        this.value1 = value1;
        this.searchOperation1 = searchOperation1;
    }

    public SearchCriteria(String key, E1 value1, SearchOperation searchOperation1, SearchOperation searchOperation2) {
        this.key = key;
        this.value1 = value1;
        this.searchOperation1 = searchOperation1;
        this.searchOperation2 = searchOperation2;
    }
}
