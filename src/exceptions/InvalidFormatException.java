package exceptions;

import model.PizzaConfig;

public class InvalidFormatException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public InvalidFormatException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        System.out.println("The file contains an invalid format line");
        // handle the exception

    }
}
