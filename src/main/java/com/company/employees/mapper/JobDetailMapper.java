package com.company.employees.mapper;

import com.company.employees.dto.request.JobDetailRequest;
import com.company.employees.dto.response.JobDetailResponse;
import com.company.employees.entity.Employee;
import com.company.employees.entity.JobDetail;
import org.springframework.stereotype.Component;

@Component
public class JobDetailMapper {

    public JobDetail toEntity(JobDetailRequest jobDetailRequest) {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setStartDate(jobDetailRequest.getStartDate());
        jobDetail.setEndDate(jobDetailRequest.getEndDate());
        jobDetail.setCurrentSalary(jobDetailRequest.getSalary());
//        jobDetail.setLastSalary(jobDetailRequest.getSalary());
        jobDetail.setPresent(jobDetailRequest.isPresent());
        return jobDetail;
    }

    public JobDetail toEntity(JobDetailRequest jobDetailRequest, Employee employee) {
        JobDetail jobDetail = new JobDetail();
        jobDetail.setStartDate(jobDetailRequest.getStartDate());
        jobDetail.setEndDate(jobDetailRequest.getEndDate());
        jobDetail.setCurrentSalary(jobDetailRequest.getSalary());
//        jobDetail.setLastSalary(jobDetailRequest.getSalary());
        jobDetail.setPresent(jobDetailRequest.isPresent());
        jobDetail.setEmployee(employee);
        return jobDetail;
    }

    public JobDetailResponse toResponse(JobDetail jobDetail) {
        JobDetailResponse jobDetailResponse = new JobDetailResponse();
        jobDetailResponse.setId(jobDetail.getId());
        jobDetailResponse.setCreatedAt(jobDetail.getCreatedAt());
        jobDetailResponse.setStartDate(jobDetail.getStartDate());
        jobDetailResponse.setEndDate(jobDetail.getEndDate());
        jobDetailResponse.setPresent(jobDetail.isPresent());
        jobDetailResponse.setSalary(jobDetail.getCurrentSalary());
        return jobDetailResponse;
    }
}
