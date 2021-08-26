package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado enviada
 *
 * @author Julio Hurtado, Libardo Pantoja
 */
public class SendState extends OrderState {

    /**
     * @param order to be processed
     */
    public SendState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Enviada";
    }

    @Override
    public OrderState orderLost() {
        return new LostState(getOrder());
    }

    @Override
    public OrderState orderDelivered() {
        return new DeliveredState(getOrder());
    }
}
