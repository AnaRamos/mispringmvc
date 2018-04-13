package com.micompania.miapp.beans;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class BeanSaludo {
	@Value("Saludos desde el Bean Inyectado ")
	private String mensaje;
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
	
}
