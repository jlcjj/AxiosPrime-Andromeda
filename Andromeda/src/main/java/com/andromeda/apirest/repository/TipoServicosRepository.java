package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.TipoServicos;

public interface TipoServicosRepository extends  JpaRepository<TipoServicos, Long>{
	
	TipoServicos findById(long id);

}
