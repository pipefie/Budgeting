package Clases;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class CuentaTest {

	@Test
	void testCuentaStringTipoCuentaBigDecimal() {
		try {
			BigDecimal decimal = new BigDecimal("123.44");
			Cuenta cuenta =  new Cuenta("usu", TipoCuenta.Ahorro, decimal);
		}catch (Exception e) {
			fail("No funciona");
		}
		
	}

}
