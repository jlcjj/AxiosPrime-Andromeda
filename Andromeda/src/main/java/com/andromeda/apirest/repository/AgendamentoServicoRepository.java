package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.Agendamento;
import com.andromeda.apirest.moldels.AgendamentoServico;

public interface AgendamentoServicoRepository extends  JpaRepository<AgendamentoServico, Long>{
	
	Agendamento findById(long id);

}
