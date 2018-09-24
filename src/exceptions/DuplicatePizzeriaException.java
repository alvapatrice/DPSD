package exceptions;

import model.PizzaConfig;

public class DuplicatePizzeriaException extends CustomException {
    private PizzaConfig pizzaConfig;
    private  String exception;
    public DuplicatePizzeriaException(String exception, PizzaConfig pizzaConfig) {
        super(exception,pizzaConfig);
        this.pizzaConfig=pizzaConfig;
        this.exception=exception;
    }

    @Override
    public void handleException() {
        System.out.println("The pizza already exists");
        // handle the exception
        //append 2 to the current name
        String name= pizzaConfig.getName();
        pizzaConfig.setName(name+"2");

    }
}
