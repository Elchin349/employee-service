package com.company.employees.repository.search;

public enum SearchOperation {
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_EQUAL,
    LESS_THAN_EQUAL,
    NOT_EQUAL,
    EQUAL,
    MATCH,
    MATCH_START,
    MATCH_END,
    IN,
    BETWEEN_DATE,
    BETWEEN_SALARY,
    NOT_IN,
    JOIN_ADDRESS,
    JOIN_JOB_DETAILS
}
