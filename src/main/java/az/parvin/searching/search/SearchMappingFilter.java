package az.parvin.searching.search;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class SearchMappingFilter {

    public SearchFilter setMapFilter(
            Integer page,
            Integer size,
            String name,
            String surname,
            String pinCode,
            Double gpa,
            LocalDate birthdate,
            BigDecimal scholarship,
            String country,
            String city,
            String addressLine,
            String author,
            String authorName,
            Integer year,
            String teacherName,
            String teacherSurname,
            String grade,
            String gender
    ) {
        SearchFilter filter = new SearchFilter();
        filter.setPage(page);
        filter.setSize(size);
        if (!ObjectUtils.isEmpty(name))
            filter.setName(name);
        if (!ObjectUtils.isEmpty(surname))
            filter.setSurname(surname);
        if (!ObjectUtils.isEmpty(pinCode))
            filter.setPinCode(pinCode);
        if (!ObjectUtils.isEmpty(gpa))
            filter.setGpa(gpa);
        if (!ObjectUtils.isEmpty(birthdate))
            filter.setBirthdate(birthdate);
        if (!ObjectUtils.isEmpty(scholarship))
            filter.setScholarship(scholarship);
        if (!ObjectUtils.isEmpty(country))
            filter.setCountry(country);
        if (!ObjectUtils.isEmpty(city))
            filter.setCity(city);
        if (!ObjectUtils.isEmpty(addressLine))
            filter.setAddressLine(addressLine);
        if (!ObjectUtils.isEmpty(author))
            filter.setAuthor(author);
        if (!ObjectUtils.isEmpty(authorName))
            filter.setAuthorName(authorName);
        if (!ObjectUtils.isEmpty(year))
            filter.setYear(year);
        if (!ObjectUtils.isEmpty(teacherName))
            filter.setTeacherName(teacherName);
        if (!ObjectUtils.isEmpty(teacherSurname))
            filter.setTeacherSurname(teacherSurname);
        if (!ObjectUtils.isEmpty(grade))
            filter.setGrade(grade);
        if (!ObjectUtils.isEmpty(gender))
            filter.setGender(gender);
        return filter;
    }
}
