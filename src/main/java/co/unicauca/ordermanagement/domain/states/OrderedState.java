package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado ordenado
 *
 * @author ahurtado
 */
public class OrderedState extends OrderState {

    /**
     * @param order to be processed
     */
    public OrderedState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Ordenada";
    }

    @Override
    public OrderState cancel() {
        return new CanceledState(getOrder());
    }
    
    @Override
    public OrderState orderPayed() {
        if (getOrder().isPaymentReceived() == false) {
            throw new IllegalStateException("payment not received.");
        }
        return new PayedState(getOrder());
    }

    @Override
    public OrderState orderSendOut(String parcelNumber) {
        if (!getOrder().isPaymentReceived()) {
            throw new IllegalStateException("An order should not be send out when payment is not received.");
        }
        return new SendState(getOrder());
    }

}
