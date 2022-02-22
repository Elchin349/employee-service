package com.company.employees.repository.search;

import com.company.employees.constants.CommonConstant;
import com.company.employees.dto.request.EmployeeSearchFilter;
import com.company.employees.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.company.employees.constants.CommonConstant.EmployeeFilterConstant.FIRST_NAME;

public class SearchSpecification implements Specification<Employee> {

    private static final long serialVersionUID = -4225152467158560108L;

    private List<SearchCriteria> criteriaList = new ArrayList<>();

    private void add(SearchCriteria searchCriteria) {
        criteriaList.add(searchCriteria);
    }

    public void search(EmployeeSearchFilter filter) {
        if (!ObjectUtils.isEmpty(filter.getFirstName())) {
            add(new SearchCriteria(FIRST_NAME, filter.getFirstName(), SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getLastName())) {
            add(new SearchCriteria("lastName", filter.getLastName(), SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(filter.getGender())) {
            add(new SearchCriteria("gender", filter.getGender(), SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(filter.getFinCode())) {
            add(new SearchCriteria("finCode", filter.getFinCode(), SearchOperation.EQUAL));
        }
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : criteriaList) {
            if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue1()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue1().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue1().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {

            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {

            } else if (criteria.getOperation().equals(SearchOperation.BETWEEN_DATE)) {
                predicates.add(builder.between(root.get(criteria.getKey()),
                        (LocalDate) criteria.getValue1(),
                        (LocalDate) criteria.getValue2()));
            }
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }

    @Override
    public Specification<Employee> and(Specification<Employee> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Employee> or(Specification<Employee> other) {
        return Specification.super.or(other);
    }
}
