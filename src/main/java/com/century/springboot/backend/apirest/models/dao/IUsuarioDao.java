package com.century.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.century.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

	//Consulta por method
	public Usuario findByUsername(String username);
	
	//Consulta por query
	@Query("select u from Usuario u where u.username=?1")
	public Usuario findByUsernamWithQuery(String username);
	
}
