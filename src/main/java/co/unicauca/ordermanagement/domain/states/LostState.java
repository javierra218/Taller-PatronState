package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado perdido
 *
 * @author Julio Hurtado, Libardo Pantoja
 */
public class LostState extends OrderState {

    /**
     * @param order to be processed
     */
    public LostState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Perdida";
    }

    /**
     * @return nuevo estado como CanceledState
     */
    @Override
    public OrderState cancel() {
        return new CanceledState(getOrder());
    }

    /**
     * @return nuevo estado como DeliveredState
     */
    @Override
    public OrderState orderSendOut(String number) {
        return new SendState(getOrder());
    }
}
