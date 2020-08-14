package com.exlogutest.exceptionExample;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ServiceRepo extends PagingAndSortingRepository<Employee, Integer>
{
	

}
