package com.waldos.test.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waldos.test.api.dao.UsuarioDao;
import com.waldos.test.api.model.entities.Usuario;

@Service
public class UsuarioService {

	private static Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioDao usuarioDao;

	@Transactional(readOnly = true)
	public List<Usuario> findAllUsuarios() {
		log.info("CONSULTANDO TODOS LOS USUARIOS");
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario findById(Integer id) {
		log.info("CONSULTANDO EL USUARIO CON EL ID " + id);
		return usuarioDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Usuario findByUsuarioAndPassword(String usuario, String password) {
		log.info("CONSULTANDO USUARIO POR USUARIO: " + usuario + " Y PASSWORD: " + password);
		return usuarioDao.findByUsuarioAndPassword(usuario, password);
	}

	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		log.info("REGISTRANDO USUARIO");
		return usuarioDao.save(usuario);
	}

	@Transactional
	public Usuario updateUsuario(Usuario usuario) {
		log.info("ACTUALIZANDO USUARIO");
		return usuarioDao.save(usuario);
	}

	@Transactional
	public void deleteUsuario(Integer id) {
		log.info("ELIMINANDO USUARIO CON ID: " + id);
		usuarioDao.deleteById(id);
	}
}
