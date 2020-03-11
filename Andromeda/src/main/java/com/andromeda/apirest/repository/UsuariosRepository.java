package com.andromeda.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andromeda.apirest.moldels.Usuarios;

public interface UsuariosRepository extends  JpaRepository<Usuarios, Long>{
	
	Usuarios findById(long id);

}
