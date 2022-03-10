package az.parvin.searching.search.student;

import az.parvin.searching.entity.Address;
import az.parvin.searching.entity.Book;
import az.parvin.searching.entity.Student;
import az.parvin.searching.entity.Teacher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SearchSpecification implements Specification<Student> {

    private static final long serialVersionUID = -6367804240777724876L;

    private List<SearchCriteria> criteriaList = new ArrayList<>();

    public void search(SearchFilter filter) {
        if (!ObjectUtils.isEmpty(filter.getName())) {
            add(new SearchCriteria("name", filter.getName(), SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getSurname())) {
            add(new SearchCriteria("surname", filter.getSurname(), SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getPinCode())) {
            add(new SearchCriteria("pinCode", filter.getPinCode(), SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getGpa())) {
            add(new SearchCriteria("gpa", filter.getGpa(), SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getBirthdate())) {
            add(new SearchCriteria("birthdate", filter.getBirthdate(), SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getMinScholarship()) && !ObjectUtils.isEmpty(filter.getMaxScholarship())) {
            add(new SearchCriteria("scholarship", filter.getMinScholarship(), filter.getMaxScholarship(),
                    SearchOperation.BETWEEN_SCHOLARSHIP));
        }
        if (!ObjectUtils.isEmpty(filter.getCountry())) {
            add(new SearchCriteria("country", filter.getCountry(), SearchOperation.JOIN_ADDRESS,
                    SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getCity())) {
            add(new SearchCriteria("city", filter.getCity(), SearchOperation.JOIN_ADDRESS, SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getAddressLine())) {
            add(new SearchCriteria("addressLine", filter.getAddressLine(), SearchOperation.JOIN_ADDRESS,
                    SearchOperation.MATCH));
        }
        if (!ObjectUtils.isEmpty(filter.getAuthor())) {
            add(new SearchCriteria("authorName", filter.getAuthorName(), SearchOperation.JOIN_BOOKS,
                    SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getYear())) {
            add(new SearchCriteria("year", filter.getYear(), SearchOperation.JOIN_BOOKS, SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getTeacherName())) {
            add(new SearchCriteria("teacherName", filter.getTeacherName(), SearchOperation.JOIN_TEACHERS, // partlaya biler
                    SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getTeacherSurname())) {
            add(new SearchCriteria("teacherSurname", filter.getTeacherSurname(), SearchOperation.JOIN_TEACHERS,
                    SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getGrade())) {
            add(new SearchCriteria("grade", filter.getGrade(), SearchOperation.JOIN_TEACHERS,
                    SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getGender())) {
            add(new SearchCriteria("gender", filter.getGender(), SearchOperation.JOIN_TEACHERS,
                    SearchOperation.EQUAL));
        }
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : criteriaList) {
            if (criteria.getOperation1().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue1()));
            } else if (criteria.getOperation1().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue1().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation1().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue1().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation1().equals(SearchOperation.BETWEEN_SCHOLARSHIP)) {
                predicates.add(builder.between(root.get(criteria.getKey()),
                        (BigDecimal) criteria.getValue1(), (BigDecimal) criteria.getValue2()));
            } else if (criteria.getOperation1().equals(SearchOperation.JOIN_ADDRESS)) {
                Join<Student, Address> studentAddressJoin = root.join("address", JoinType.INNER);
                if (criteria.getOperation2().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(studentAddressJoin.get(criteria.getKey()).as(String.class), criteria.getValue1()));
                } else if (criteria.getOperation2().equals(SearchOperation.MATCH)) {
                    predicates.add(
                            builder.like(builder.lower(studentAddressJoin.get(criteria.getKey())),
                                    "%" + criteria.getValue1().toString().toLowerCase() + "%"));
                } else if (criteria.getOperation2().equals(SearchOperation.MATCH_START)) {
                    predicates.add(
                            builder.like(builder.lower(studentAddressJoin.get(criteria.getKey())),
                                    criteria.getValue1().toString().toLowerCase() + "%"));
                }
            } else if (criteria.getOperation1().equals(SearchOperation.JOIN_BOOKS)) {
                Join<Student, Book> studentBookJoin = root.join("books", JoinType.INNER);
                if (criteria.getOperation2().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(studentBookJoin.get(criteria.getKey()), criteria.getValue1()));
                } else if (criteria.getOperation2().equals(SearchOperation.MATCH_START)) {
                    predicates.add(
                            builder.like(builder.lower(studentBookJoin.get(criteria.getKey())),
                                    criteria.getValue1().toString().toLowerCase() + "%"));
                }
            } else if (criteria.getOperation1().equals(SearchOperation.JOIN_TEACHERS)) {
                Join<Student, Teacher> studentTeacherJoin = root.join("teachers", JoinType.INNER);
                if (criteria.getOperation2().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(studentTeacherJoin.get(criteria.getKey()), criteria.getValue1()));
                } else if (criteria.getOperation2().equals(SearchOperation.MATCH_START)) {
                    predicates.add(
                            builder.like(builder.lower(studentTeacherJoin.get(criteria.getKey())),
                                    criteria.getValue1().toString().toLowerCase() + "%"));
                }
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }

    private void add(SearchCriteria searchCriteria) {
        criteriaList.add(searchCriteria);
    }

    @Override
    public Specification<Student> and(Specification<Student> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Student> or(Specification<Student> other) {
        return Specification.super.or(other);
    }
}
