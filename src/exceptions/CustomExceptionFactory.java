package exceptions;

import model.PizzaConfig;

public class CustomExceptionFactory {
    public static CustomException createException(String exception, PizzaConfig pizzaConfig){
        switch (exception){
            case "missingPrice": return new MissingPriceException(exception,pizzaConfig);
            case "missingName":return new NameMissingException(exception,pizzaConfig);
            case "optionNotFound":return new OptionNotFoundException(exception,pizzaConfig);
            case "optionDuplicate":return new DuplicateOptionException(exception,pizzaConfig);
            case "invalidPrice":return new InvalidPriceException(exception,pizzaConfig);
            case "duplicateOptionSet":return new DuplicateOptionSetException(exception,pizzaConfig);
            case "optionSetNotFound":return new OptionSetNotFoundException(exception,pizzaConfig);
            case "duplicatePizzeria":return new DuplicatePizzeriaException(exception,pizzaConfig);
            case "pizzeriaNotFound":return new PizzeriaNotFoundException(exception,pizzaConfig);
            case "invalidPizzeria":return new InvalidPizzeriaException(exception,pizzaConfig);
            case "invalidFormat":return new InvalidFormatException(exception,pizzaConfig);
            default:return new UncheckedException("Unknown",pizzaConfig);

        }
    }
}
