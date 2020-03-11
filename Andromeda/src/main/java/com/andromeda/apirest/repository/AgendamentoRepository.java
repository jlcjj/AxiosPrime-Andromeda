package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.Agendamento;

public interface AgendamentoRepository extends  JpaRepository<Agendamento, Long>{
	
	Agendamento findById(long id);

}
