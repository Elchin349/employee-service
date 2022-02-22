package com.company.employees.repository.search;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria<E1, E2> {
    private String key;
    private E1 value1;
    private E2 value2;
    private SearchOperation operation;

    public SearchCriteria(String key, E1 value1, SearchOperation operation) {
        this.key = key;
        this.value1 = value1;
        this.operation = operation;
    }
}
