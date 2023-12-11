package Clases;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import org.junit.jupiter.api.Test;

class TransaccionTest {

	@Test
	void testTransaccionCuentaBigDecimalCurrencyStringDateCategoryofTransaction() {
		try {
			BigDecimal decimal = new BigDecimal("123.44");
			Cuenta cuenta =  new Cuenta("usu", TipoCuenta.Ahorro, decimal);
			Date date = new Date();
			Transaccion trans = new Transaccion(cuenta,  decimal, Currency.getInstance((String)"USD"), 
					"comment", date, CategoryofTransaction.AHORROS);
		}catch(Exception e) {
			fail("No funciona");
		}

	}

}
