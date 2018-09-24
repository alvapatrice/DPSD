package wrapper;

import exceptions.CustomException;
import model.PizzaConfig;

import java.util.ArrayList;

public interface CreatePizzeria {
    //create the pizzeria with the pizza configuration(s)
    public void createPizzeria(PizzaConfig pizzaConfig)throws CustomException;

    // build an instance of your pizzeria configuration
    public void configurePizzeria(String filename) throws CustomException;

    //print the properties of a given pizzeria
    public void printPizzeria();

}
