package exceptions;

import model.PizzaConfig;

public class OptionSetNotFoundException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public OptionSetNotFoundException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        System.out.println("The option set was not found");
        // handle the exception

    }
}
