package exceptions;

import model.PizzaConfig;

public class InvalidPizzeriaException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public InvalidPizzeriaException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.pizzaConfig=pizzaConfig;
        this.exception=exception;
    }

    @Override
    public void handleException() {
        System.out.println("The pizza configurations are invalid");
        // handle the exception

    }
}
