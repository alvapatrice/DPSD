package exceptions;

import model.PizzaConfig;

public class InvalidPriceException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public InvalidPriceException(String exception,PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.pizzaConfig=pizzaConfig;
        this.exception=exception;
    }

    @Override
    public void handleException() throws CustomException {
        System.out.println("The price is invalid");
        // handle the exception

        double price=0;
        pizzaConfig.setBasePrice(price);

    }
}
