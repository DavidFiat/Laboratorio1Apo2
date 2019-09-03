package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

class CasillaTest {

	private Casilla casillas;
	
private void escenario() {
		casillas = new Casilla(Casilla.MINA);
	}
	private void escenario2() {
		casillas = new Casilla(Casilla.LIBRE);
	}
	private void escenario3() {
		casillas = new Casilla(Casilla.LIBRE);
		casillas.modificarValor(1);
	}

	@Test
	private void modificarValor() {
		escenario3();
		assertTrue (casillas.darValor() == 1, "No cambio valor");
	}
	@Test
	private void esMina() {
		escenario2();
		assertTrue(casillas.esMina() == false, "Es mina");
	}
	

}

