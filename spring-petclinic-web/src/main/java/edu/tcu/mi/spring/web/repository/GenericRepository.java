package edu.tcu.mi.spring.web.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface GenericRepository<T> extends PagingAndSortingRepository<T, String> {
}
