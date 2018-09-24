package exceptions;

import model.PizzaConfig;

public class NameMissingException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public NameMissingException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.pizzaConfig= pizzaConfig;
        this.exception=exception;
    }

    @Override
    public void handleException() {
        // handle name missing exception
        System.out.println("The pizza is missing a name");
        //set a the name to default
        pizzaConfig.setName("default");

    }
}
