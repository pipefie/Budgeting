package Clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void testUsuarioStringStringStringString() {
		try {
			Usuario usuario = new Usuario("nombre", "apellidos", "correo@gmail.com", "contrasena");
		}catch (Exception e) {
		fail("Not yet implemented");
		}
	}

}
