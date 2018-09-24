package exceptions;

import model.PizzaConfig;

public abstract class CustomException extends Exception {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public CustomException(String exception, PizzaConfig pizzaConfig) {
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }
    public abstract void handleException() throws CustomException;
}
