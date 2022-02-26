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
    private SearchOperation operation2;

    public SearchCriteria(String key, E1 value1, SearchOperation operation) {
        this.key = key;
        this.value1 = value1;
        this.operation = operation;
    }

    public SearchCriteria(String key, E1 value1, SearchOperation operation, SearchOperation operation2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.operation = operation;
        this.operation2 = operation2;
    }


}
