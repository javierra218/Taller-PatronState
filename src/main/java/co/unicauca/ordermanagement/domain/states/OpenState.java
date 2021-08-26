package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Dish;
import co.unicauca.ordermanagement.domain.Item;
import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado abierto o inical
 *
 * @author Julio Hurtado, Libardo Pantoja
 */
public class OpenState extends OrderState {

    /**
     * @param order to be processed
     */
    public OpenState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Abierta";
    }

    /**
     * @return this, el estado actual
     */
    @Override
    public OrderState addItem(Dish item, int quantity) {
        getOrder().add(new Item(item, quantity));
        return this;
    }

    /**
     * @return nuevo estado como CanceledState
     * @throws IllegalStateException si no hay dirección asociada
     */

    @Override
    public OrderState confirmOrder() {
        if (getOrder().isEmpty()) {
            //we could throw an exception instead...
            return new CanceledState(getOrder());
        } else if (getOrder().getAddress() == null) {
            throw new IllegalStateException("An address is needed before the order can be confirmed.");
        }
        return new OrderedState(getOrder());
    }

    /**
     * @return nuevo estado como CanceledState
     */
    @Override
    public OrderState cancel() {
        return new CanceledState(getOrder());
    }

}
