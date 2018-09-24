package exceptions;

import model.PizzaConfig;

public class DuplicateOptionSetException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public DuplicateOptionSetException(String exception, PizzaConfig pizzaConfig) {
        super(exception, pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        System.out.println("Duplicated option set");
        // handle the exception
    }
}
