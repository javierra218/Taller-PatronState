package co.unicauca.serversocket.ordermanagement.domain;

import co.unicauca.ordermanagement.domain.Dish;
import co.unicauca.ordermanagement.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ahurtado
 */
public class OrderTest {
        private Order order;
	private String address;
	private Dish vegetariano;
	private Dish pasta;

	@BeforeEach
	public void instantiateFixtures() {
		order = new Order();
		address = "Mr S. Claus"+" Northpole 1A"+" Arctica";
		vegetariano = createDish(1001, "Plato Vegetariano",8000);
		pasta = createDish(1002, "Plato de Pasta",10000);
	}

	private Dish createDish(int id, String name, int price) {
		Dish dish = new Dish(id, name,price);
		return dish;
	}

	@Test
	public void testNormalFlow() {
		order.setAddress(address);
		order.setPaymentReceived(true);
		order.addItem(vegetariano, 4);
		order.addItem(pasta, 20);
		assertEquals("Abierta", order.whatIsTheState());
		order.confirmOrder();
		assertEquals("Ordenada", order.whatIsTheState());
                order.orderPayed();
                assertEquals("Pagada", order.whatIsTheState());
		order.orderSendOut("555555X");
		assertEquals("Enviada", order.whatIsTheState());
		order.orderDelivered();
		assertEquals("Entregada", order.whatIsTheState());
		assertTrue(order.isFinished());
	}

        @Test
	public void testExceptionalFlow() {
		order.setAddress(address);
		order.setPaymentReceived(true);
		order.addItem(vegetariano, 4);
		order.addItem(pasta, 20);
		assertEquals("Abierta", order.whatIsTheState());
		order.confirmOrder();
		assertEquals("Ordenada", order.whatIsTheState());
                order.orderPayed();
                assertEquals("Pagada", order.whatIsTheState());
		order.orderSendOut("555555X");
		assertEquals("Enviada", order.whatIsTheState());
		try{
                    order.cancel();
                }
                catch(Exception exp){
                    assertEquals(exp.getMessage(),"No se puede cancelar la orden cuando la orden está Enviada");
                }
                
	}
        
        @Test
	public void AlternativeFlow() {
		order.setAddress(address);
		order.setPaymentReceived(true);
		order.addItem(vegetariano, 4);
                assertEquals("Abierta", order.whatIsTheState());
		order.confirmOrder();
                assertEquals("Ordenada", order.whatIsTheState());
                order.cancel();
                assertEquals("Cancelada", order.whatIsTheState());      
	}
}
