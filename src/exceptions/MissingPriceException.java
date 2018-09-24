package exceptions;

import model.PizzaConfig;

public class MissingPriceException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public MissingPriceException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.pizzaConfig=pizzaConfig;
        this.exception=exception;
    }

    @Override
    public void handleException() throws CustomException {
        // handle the exception
        System.out.println("The pizza is missing price");

        // set the price to zero
        double price=0;
        pizzaConfig.setBasePrice(price);
    }

}
