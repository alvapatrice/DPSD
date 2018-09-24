package exceptions;

import model.PizzaConfig;

public class PizzeriaNotFoundException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public PizzeriaNotFoundException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        System.out.println("The pizza was not found");
        // handle the exception

    }
}
