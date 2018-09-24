package exceptions;

import model.PizzaConfig;

public class OptionNotFoundException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public OptionNotFoundException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        System.out.println("The option was not found");
        // handle the exception

    }
}
