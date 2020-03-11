package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.ContasReceber;

public interface ContasReceberRepository extends  JpaRepository<ContasReceber, Long>{
	
	ContasReceber findById(long id);

}
