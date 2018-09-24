package exceptions;

import model.PizzaConfig;

public class UncheckedException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public UncheckedException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.exception=exception;
        this.pizzaConfig=pizzaConfig;
    }

    @Override
    public void handleException() {
        //handle unchecked exception
        System.out.println("unchecked exception");
    }
}
