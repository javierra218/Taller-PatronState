/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.ordermanagement.presentation;

import co.unicauca.ordermanagement.domain.Dish;
import co.unicauca.ordermanagement.domain.Order;

/**
 *
 * @author libardo
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String address = "Mr S. Claus" + " Northpole 1A" + " Arctica";
        Dish vegetariano = createDish(1001, "Plato Vegetariano", 8000);
        Dish pasta = createDish(1002, "Plato de Pasta", 10000);

        // Flujo normal
        Order order = new Order();
        order.setAddress(address);
        order.setPaymentReceived(true);
        order.addItem(vegetariano, 4);
        order.addItem(pasta, 20);
        System.out.println("Estado: " + order.whatIsTheState());
        order.confirmOrder();
        System.out.println("Estado: " + order.whatIsTheState());
        order.orderPayed();
        System.out.println("Estado: " + order.whatIsTheState());
        order.orderSendOut("555555X");
        System.out.println("Estado: " + order.whatIsTheState());
        order.orderDelivered();
        System.out.println("Estado: " + order.whatIsTheState());

        //Flujo alternativo
        order = new Order();
        order.setAddress(address);
        order.setPaymentReceived(true);
        order.addItem(vegetariano, 2);
        order.addItem(pasta, 4);
        order.confirmOrder();
        System.out.println("\nEstado: " + order.whatIsTheState());
        order.cancel();
        System.out.println("Estado: " + order.whatIsTheState());

        //Flujo excepcional
        order = new Order();
        order.setAddress(address);
        order.setPaymentReceived(true);
        order.addItem(vegetariano, 1);
        order.addItem(pasta, 1);
        order.confirmOrder();
        System.out.println("\nEstado: " + order.whatIsTheState());
        order.orderPayed();
        System.out.println("Estado: " + order.whatIsTheState());
        order.orderSendOut(address);
        System.out.println("Estado: " + order.whatIsTheState());
        try {
            order.cancel();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static Dish createDish(int id, String name, int price) {
        Dish dish = new Dish(id, name, price);
        return dish;
    }
}
