package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 * Estado cancelado
 *
 * @author Julio Hurtado, Libardo Pantoja
 */
public class CanceledState extends OrderState {

    /**
     * @param order to be processed
     */
    public CanceledState(Order order) {
        super(order);
    }

    /**
     * @return description
     */
    @Override
    public String getStateDescription() {
        return "Cancelada";
    }

    /**
     * @return true por orden finalizada
     */
    @Override
    public boolean isFinished() {
        return true;
    }
}
