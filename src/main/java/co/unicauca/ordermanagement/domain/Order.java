package co.unicauca.ordermanagement.domain;

import co.unicauca.ordermanagement.domain.states.OpenState;
import co.unicauca.ordermanagement.domain.states.OrderState;
import java.util.ArrayList;
import java.util.List;

/**
 * Contexto
 *
 * @author Libardo Pantoja, Julio Hurtado
 */
public class Order {

    private OrderState orderState;
    private List<Item> lines;
    private String address;
    private boolean paymentReceived;

    public Order() {
        // En este estado se pasa como argumento el contexto, y luego
        // los demás estados se la pasan
        orderState = new OpenState(this);
        lines = new ArrayList<>();

    }

    /**
     * Just for visualizing in test/UI
     *
     * @return descripción de la orden
     */
    public String whatIsTheState() {
        return orderState.getStateDescription();
    }

    public List<Item> getLines() {
        return lines;
    }

    public void setLines(List<Item> lines) {
        this.lines = lines;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPaymentReceived() {
        return paymentReceived;
    }

    public void setPaymentReceived(boolean paymentReceived) {        
        this.paymentReceived = paymentReceived;
    }

    /**
     * @param item que corresponde al plato
     * @param quantity que corresponde a la cantidad de platos
     */
    public void addItem(Dish item, int quantity) {
        orderState = orderState.addItem(item, quantity);
    }

    public void cancel() {
        orderState = orderState.cancel();
    }

    public void confirmOrder() {
        orderState = orderState.confirmOrder();
    }

    public void orderDelivered() {
        orderState = orderState.orderDelivered();
    }

    public void orderSendOut(String parcelNumber) {
        orderState = orderState.orderSendOut(parcelNumber);
    }
    
    public void orderPayed(){
        orderState = orderState.orderPayed();
    }

    public boolean isFinished() {
        return orderState.isFinished();
    }
    

    public void add(Item line) {
        lines.add(line);
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }
    
}
