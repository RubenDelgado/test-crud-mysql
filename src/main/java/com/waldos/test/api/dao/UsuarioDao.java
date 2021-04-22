package com.waldos.test.api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.waldos.test.api.model.entities.Usuario;



public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

	@Query("SELECT new Usuario(u.id, u.nombre, u.apellido, u.usuario, u.password, u.status) "
			+ "FROM Usuario u "
			+ "WHERE 1=1 "
			+ "AND u.usuario = :usuario "
			+ "AND u.password = :password ")
	public Usuario findByUsuarioAndPassword(@Param("usuario") String usuario, @Param("password") String password);
	
}
