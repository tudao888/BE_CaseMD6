package com.be_casemd6.repository;

import com.be_casemd6.model.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBillRepo extends PagingAndSortingRepository<Bill,Integer> {
}
