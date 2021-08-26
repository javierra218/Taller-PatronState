/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.ordermanagement.domain.states;

import co.unicauca.ordermanagement.domain.Order;

/**
 *
 * @author Javier
 */
public class PayedState extends OrderState {
    
    public PayedState(Order order) {
        super(order);
    }

    @Override
    public String getStateDescription() {
        return "Pagada";
    }

    @Override
    public OrderState orderSendOut(String parcelNumber) {
        if (!getOrder().isPaymentReceived()) {
            throw new IllegalStateException("No se puede enviar cuando no hay pago");
        }
        return new SendState(getOrder());
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
