package com.company.employees.repository.search;

import com.company.employees.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchSpecification implements Specification<Employee> {

    private static final long serialVersionUID = -4225152467158560108L;

    private List<SearchCriteria> criteriaList = new ArrayList<>();

    private void add(SearchCriteria searchCriteria) {
        criteriaList.add(searchCriteria);
    }

    public void search(String firstName, String lastName, String gender, String finCode, LocalDate start, LocalDate end) {
        if (!ObjectUtils.isEmpty(firstName)) {
            add(new SearchCriteria("firstName", firstName, SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(lastName)) {
            add(new SearchCriteria("lastName", lastName, SearchOperation.MATCH_START));
        }
        if (!ObjectUtils.isEmpty(gender)) {
            add(new SearchCriteria("gender", gender, SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(finCode)) {
            add(new SearchCriteria("finCode", finCode, SearchOperation.EQUAL));
        }
        if (!ObjectUtils.isEmpty(start)) {
            add(new SearchCriteria("birthDate", finCode, SearchOperation.GREATER_THAN_EQUAL));
        }
        if (!ObjectUtils.isEmpty(end)) {
            add(new SearchCriteria("birthDate", finCode, SearchOperation.LESS_THAN_EQUAL));
        }
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        for (SearchCriteria criteria : criteriaList) {
            if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(builder.equal(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
                        (LocalDate) criteria.getValue())
                );
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), (LocalDate) criteria.getValue())
                );
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
