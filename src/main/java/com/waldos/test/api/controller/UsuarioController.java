package com.waldos.test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.waldos.test.api.model.entities.Usuario;
import com.waldos.test.api.service.UsuarioService;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/findAllUsuarios")
	public ResponseEntity<Object> findAllUsuarios() {
		return new ResponseEntity<Object>(usuarioService.findAllUsuarios(), HttpStatus.OK);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {
		return new ResponseEntity<Object>(usuarioService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/findByUsuarioAndPassword")
	public ResponseEntity<Object> findById(@RequestHeader("usuario") String usuario, @RequestHeader("password") String password) {
		return new ResponseEntity<Object>(usuarioService.findByUsuarioAndPassword(usuario, password), HttpStatus.OK);
	}

	@PostMapping("/saveUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@PutMapping("/updateUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(usuario);
	}

	@DeleteMapping("/deleteUsuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Integer id) {
		usuarioService.deleteUsuario(id);
	}

}
