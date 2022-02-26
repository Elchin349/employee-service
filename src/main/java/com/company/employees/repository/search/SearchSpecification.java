package com.company.employees.repository.search;

import com.company.employees.constants.CommonConstant;
import com.company.employees.dto.request.EmployeeSearchFilter;
import com.company.employees.entity.Address;
import com.company.employees.entity.Employee;
import com.company.employees.entity.JobDetail;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
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

        if (!ObjectUtils.isEmpty(filter.getCity())) {
            add(new SearchCriteria("city", filter.getCity(), SearchOperation.JOIN_ADDRESS, SearchOperation.EQUAL));
        }

        if (!ObjectUtils.isEmpty(filter.getSalaryMin()) && !ObjectUtils.isEmpty(filter.getSalaryMax())) {
            add(new SearchCriteria("currentSalary", filter.getSalaryMin(),filter.getSalaryMax(),
                    SearchOperation.JOIN_JOB_DETAILS, SearchOperation.BETWEEN_SALARY));
        }
//        if (!ObjectUtils.isEmpty(filter.getSalaryMin())) {
//            add(new SearchCriteria("currentSalary", filter.getSalaryMin(),
//                    SearchOperation.JOIN_JOB_DETAILS, SearchOperation.LESS_THAN_EQUAL));
//        }
//
//        if (!ObjectUtils.isEmpty(filter.getSalaryMax())) {
//            add(new SearchCriteria("currentSalary", filter.getSalaryMax(),
//                    SearchOperation.JOIN_JOB_DETAILS, SearchOperation.GREATER_THAN_EQUAL));
//        }
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
            } else if (criteria.getOperation().equals(SearchOperation.JOIN_ADDRESS)) {
                Join<Employee, Address> employeeAddressJoin = root.join("address", JoinType.INNER);
                if (criteria.getOperation2().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(employeeAddressJoin.get(criteria.getKey()).as(String.class), criteria.getValue1())
                    );
                }
            } else if (criteria.getOperation().equals(SearchOperation.JOIN_JOB_DETAILS)) {
                Join<Employee, JobDetail> employeeJobDetailJoin = root.join("jobDetail", JoinType.INNER);
                if (criteria.getOperation2().equals(SearchOperation.EQUAL)) {
                    predicates.add(
                            builder.equal(employeeJobDetailJoin.get(criteria.getKey()).as(BigDecimal.class), criteria.getValue1())
                    );
                }
                else if (criteria.getOperation2().equals(SearchOperation.LESS_THAN_EQUAL)) {
                    predicates.add(
                            builder.lessThanOrEqualTo(employeeJobDetailJoin.get(criteria.getKey()).as(BigDecimal.class),
                                    (BigDecimal) criteria.getValue1())
                    );
                } else if (criteria.getOperation2().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                    predicates.add(
                            builder.greaterThanOrEqualTo(employeeJobDetailJoin.get(criteria.getKey()).as(BigDecimal.class),
                                    (BigDecimal) criteria.getValue1())
                    );
                }
                else if (criteria.getOperation2().equals(SearchOperation.BETWEEN_SALARY)) {
                    predicates.add(
                            builder.between(employeeJobDetailJoin.get(criteria.getKey()).as(BigDecimal.class),
                                    (BigDecimal) criteria.getValue1(),
                                    (BigDecimal) criteria.getValue2()
                            )
                    );
                }
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

//       builder.between(employeeJobDetailJoin.get(criteria.getKey()).as(BigDecimal.class),
//                                    (BigDecimal) criteria.getValue1(),
//            (BigDecimal) criteria.getValue2())
}
