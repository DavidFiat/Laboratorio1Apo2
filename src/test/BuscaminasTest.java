package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;
import modelo.Casilla;

class BuscaminasTest {

	private Buscaminas busca;
	
	private void escenario1() {
		//try {
			busca = new Buscaminas(Buscaminas.INTERMEDIO);
		//}catch(Exception e) {
			//fail (e.getMessage());
		//}
	}
	@Test
	void generarMinas() {
		escenario1();
		int minas = 0;
		Casilla[][] t = busca.darCasillas();
		
		try {
			for(int i = 0; i < t.length; i++) {
				for(int j = 0; j < t[0].length; j++) {
					if(t[i][j].esMina()) {
						minas++;
					}
				}
			}
		}catch (ArrayIndexOutOfBoundsException e) {
				e.getClass();
		}
		assertTrue(minas==40, "No hay esa cantidad de minas");
	}
	@Test
	private void gano() {
		escenario1();
		busca.resolver();
		assertTrue(busca.gano(),"si gano");
	}
	@Test
	private void resolver() {
		escenario1();
		busca.resolver();
		String t = busca.mostrarTablero();
		for (int i = 0; i<t.length();i++) {
			assertTrue(t.charAt(i) != '-');
		}
	}
	@Test
	private void pista() {
		escenario1();
		String s = busca.mostrarTablero();
		busca.darPista();
		String t = busca.mostrarTablero();
		assertFalse(s.equals(t));
	}
	@Test
	private void casillasLibres() {
		escenario1();
		Casilla[][] m = busca.darCasillas();
		for(int i=0; i<m.length;i++) {
			for(int j=0; i<m[0].length;j++) {
				assertTrue(m[i][j] != null);
			}
		}	
	}
}
