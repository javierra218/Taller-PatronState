package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Dish;
import co.unicauca.ordermanagement.domain.Order;

/**
 * State
 *
 * @author Julio Hurtado, Libardo Pantoja
 */
public abstract class OrderState {

    private Order order;

    /**
     * @param order to be processed
     */
    public OrderState(Order order) {
        super();
        this.order = order;
    }

    /**
     * @return order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @return descripción
     *
     */
    public abstract String getStateDescription();

    /**
     * @param item que corresponde al plato
     * @param quantity que corresponde a la cantidad de platos
     * @return orderState
     * @throws IllegalStateException
     */
    public OrderState addItem(Dish item, int quantity) {
        throw new IllegalStateException("No pueden agregarse items cuando la orden está " + getStateDescription());
    }

    public OrderState confirmOrder() {
        throw new IllegalStateException("No se puede confirmar la orden cuando la orden está  " + getStateDescription());
    }

    public OrderState cancel() {
        throw new IllegalStateException("No se puede cancelar la orden cuando la orden está " + getStateDescription());
    }

    public OrderState orderSendOut(String parcelNumber) {
        throw new IllegalStateException("No se puede enviar la orden cuando la orden está " + getStateDescription());
    }

    public OrderState orderLost() {
        throw new IllegalStateException("No se puede perder la orden cuando la orden está " + getStateDescription());
    }

    public OrderState orderFound() {
        throw new IllegalStateException("No se puede encontrar una orden perdida cuando la orden está " + getStateDescription());
    }

    public OrderState orderDelivered() {
        throw new IllegalStateException("No se puede ordenar una orden cuando la orden está " + getStateDescription());
    }

    public OrderState orderPayed() {
        throw new IllegalStateException("No se puede pagar una orden cuando la orden No está " + getStateDescription());
    }

    public boolean isFinished() {
        return false;
    }
}
