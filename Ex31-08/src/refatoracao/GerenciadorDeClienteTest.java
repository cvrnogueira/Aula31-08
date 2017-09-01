package refatoracao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GerenciadorDeClienteTest {
	private GerenciadorDeCliente Bar1;
	@Before
	public void setUp(){
		 Bar1 = new GerenciadorDeCliente();
	}
	@Test
	public void CheckInCliente() {
		Cliente c1 = new Cliente("Catarina", 12345678, 18, "F");
		assertTrue(Bar1.checkIn(c1));
	}
	@Test
	public void CheckOutCliente() {
		Cliente c1 = new Cliente("Catarina", 12345678, 18, "F");
		Bar1.checkIn(c1);
		assertTrue(Bar1.checkOut(12345678));
	}
	@Test
	public void CheckOutCliente2() {
		Cliente c1 = new Cliente("Catarina", 12345678, 18, "F");
		Bar1.checkIn(c1);
		assertFalse(Bar1.checkOut(12345658));
	}
	@Test
	public void CheckOutCliente3() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F");
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F");
		Cliente c3 = new Cliente("Catarina", 12345673, 18, "F");
		Cliente c4 = new Cliente("Catarina", 12345674, 18, "F");
		Cliente c5 = new Cliente("Catarina", 12345675, 18, "F");
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		assertTrue(Bar1.checkOut(12345671));
	}
	@Test
	public void porcentagemMasculino() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F");
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F");
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M");
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M");
		Cliente c5 = new Cliente("Catarina", 12345675, 18, "F");
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		System.out.println(Bar1.porcentagemMasculino());
		assertEquals(Bar1.porcentagemMasculino(), 40);
	}
	@Test
	public void porcentagemFeminino() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F");
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F");
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M");
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M");
		Cliente c5 = new Cliente("Catarina", 12345675, 18, "F");
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		assertEquals(Bar1.porcentagemFeminino(), 60);
	}
	@Test
	public void qtdDePessoasNoBar() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F");
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F");
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M");
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M");
		Cliente c5 = new Cliente("Catarina", 123445675, 18, "F");
		Cliente c6 = new Cliente("Catarina", 123425675, 18, "F");
		Cliente c7 = new Cliente("Catarina", 123453675, 18, "F");
		Cliente c8 = new Cliente("Catarina", 123545675, 18, "F");
		Cliente c9 = new Cliente("Catarina", 123445675, 18, "F");
		Cliente c10 = new Cliente("Catarina", 123645675, 18, "F");
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		Bar1.checkIn(c6);
		Bar1.checkIn(c7);
		Bar1.checkIn(c8);
		Bar1.checkIn(c9);
		Bar1.checkIn(c10);
		assertEquals(Bar1.quantasPessoasNoBar(), 10);
	}
	@Test
	public void qtdDeSociosNoBar() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F", 1234);
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F",1234);
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M",1234);
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M",1234);
		Cliente c5 = new Cliente("Catarina", 123445675, 18, "F",1234);
		Cliente c6 = new Cliente("Catarina", 123425675, 18, "F");
		Cliente c7 = new Cliente("Catarina", 123453675, 18, "F");
		Cliente c8 = new Cliente("Catarina", 123545675, 18, "F");
		Cliente c9 = new Cliente("Catarina", 123445675, 18, "F");
		Cliente c10 = new Cliente("Catarina", 123645675, 18, "F");
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		Bar1.checkIn(c6);
		Bar1.checkIn(c7);
		Bar1.checkIn(c8);
		Bar1.checkIn(c9);
		Bar1.checkIn(c10);
		assertEquals(Bar1.nroSocios(), 5);
	}
	@Test
	public void qtdDeNaoSociosNoBar() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F", 1234);
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F",1234);
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M",1234);
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M",1234);
		Cliente c5 = new Cliente("Catarina", 123445675, 18, "F",1234);
		Cliente c6 = new Cliente("Catarina", 123425675, 18, "F");
		Cliente c7 = new Cliente("Catarina", 123453675, 18, "F");
		Cliente c8 = new Cliente("Catarina", 123545675, 18, "F");
		Cliente c9 = new Cliente("Catarina", 123445675, 18, "F");
		Cliente c10 = new Cliente("Catarina", 123645675, 18, "F",1234);
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		Bar1.checkIn(c6);
		Bar1.checkIn(c7);
		Bar1.checkIn(c8);
		Bar1.checkIn(c9);
		Bar1.checkIn(c10);
		assertEquals(Bar1.naoSocios(), 4);
	}
	@Test
	public void achaPorCpf() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F", 1234);
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F",1234);
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M",1234);
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M",1234);
		Cliente c5 = new Cliente("Catarina", 123445675, 18, "F",1234);
		Cliente c6 = new Cliente("Catarina", 123425676, 18, "F");
		Cliente c7 = new Cliente("Catarina", 123453677, 18, "F");
		Cliente c8 = new Cliente("Catarina", 123545678, 18, "F");
		Cliente c9 = new Cliente("Catarina", 123445679, 18, "F");
		Cliente c10 = new Cliente("Catarina", 1236456710, 18, "F",1234);
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		Bar1.checkIn(c6);
		Bar1.checkIn(c7);
		Bar1.checkIn(c8);
		Bar1.checkIn(c9);
		Bar1.checkIn(c10);
		assertEquals(Bar1.achaPorCPF(123445675), true);
	}
	@Test
	public void naoAchaPorCpf() {
		Cliente c1 = new Cliente("Catarina", 12345671, 18, "F", 1234);
		Cliente c2 = new Cliente("Catarina", 12345672, 18, "F",1234);
		Cliente c3 = new Cliente("Arthur", 12345673, 18, "M",1234);
		Cliente c4 = new Cliente("Arthur", 12345674, 18, "M",1234);
		Cliente c5 = new Cliente("Catarina", 123445675, 18, "F",1234);
		Cliente c6 = new Cliente("Catarina", 123425675, 18, "F");
		Cliente c7 = new Cliente("Catarina", 123453675, 18, "F");
		Cliente c8 = new Cliente("Catarina", 123545675, 18, "F");
		Cliente c9 = new Cliente("Catarina", 123445675, 18, "F");
		Cliente c10 = new Cliente("Catarina", 123645675, 18, "F",1234);
		Bar1.checkIn(c1);
		Bar1.checkIn(c2);
		Bar1.checkIn(c3);
		Bar1.checkIn(c4);
		Bar1.checkIn(c5);
		Bar1.checkIn(c6);
		Bar1.checkIn(c7);
		Bar1.checkIn(c8);
		Bar1.checkIn(c9);
		Bar1.checkIn(c10);
		assertEquals(Bar1.achaPorCPF(1235456711), false);
	}


}
