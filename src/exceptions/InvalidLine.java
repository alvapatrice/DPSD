package exceptions;

import model.PizzaConfig;

public class InvalidLine extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public InvalidLine(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        System.out.println("Invalid line exception");
    }
}
