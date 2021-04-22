package com.waldos.test.api.model.pojos;

import java.io.Serializable;

public class Correo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String correo;
	private String tipoCorreo;

	public Correo(String correo, String tipoCorreo) {
		this.correo = correo;
		this.tipoCorreo = tipoCorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTipoCorreo() {
		return tipoCorreo;
	}

	public void setTipoCorreo(String tipoCorreo) {
		this.tipoCorreo = tipoCorreo;
	}

}
