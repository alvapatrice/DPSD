package wrapper;

import exceptions.CustomException;
import exceptions.CustomExceptionFactory;
import io.PizzaBuilder;
import model.PizzaConfig;

import java.util.LinkedHashMap;

public abstract class ProxyPizzerias {
    private PizzaConfig pizzaConfig;
    private final LinkedHashMap<String, Object> pizzerias= new LinkedHashMap<>();

    //create the pizzeria with the pizza configuration(s)
    public synchronized void createPizzeria(PizzaConfig pizzaConfig) throws CustomException {

        //check validity
        if(pizzaConfig.validate()){
            //check duplicates
            if(!pizzerias.containsKey(pizzaConfig.getName())){
                pizzerias.put(pizzaConfig.getName(),pizzaConfig);
            }else {
                throw CustomExceptionFactory.createException("duplicatePizzeria",pizzaConfig);
            }

        }else {
            throw CustomExceptionFactory.createException("invalidPizzeria",pizzaConfig);
        }

    }

    //build an instance of your pizzeria configuration
    public  void configurePizzeria(String filename) throws CustomException {
        //build pizza configurations from the file
        PizzaBuilder pizzaBuilder=new PizzaBuilder();
        PizzaConfig pizzaConfig= pizzaBuilder.buildPizzaConfig(filename);

        //validate pizza and add it to pizzerias lists
        if(!pizzaConfig.validate()) {
            throw CustomExceptionFactory.createException("invalidPizzeria",pizzaConfig);
        }
            //check duplicates
        if(!pizzerias.containsKey(pizzaConfig.getName())){
            pizzerias.put(pizzaConfig.getName(),pizzaConfig);
        }else {
            throw CustomExceptionFactory.createException("duplicatePizzeria",pizzaConfig);

        }

    }

    //print all pizzerias in the linked list map
    public void printPizzeria(){
        pizzerias.forEach((key, value) -> {
            System.out.println("------------------------------------------------");
            this.pizzaConfig = (PizzaConfig) value;
            this.pizzaConfig.printPizzaConfig();
        });

    }

    //search the Model for the entry specified by the model name for a given OptionSet and set the name of OptionSet to newNam@Override
    public void updateOptionSetName(String pizzeriaName, String optionSetName, String newName)throws CustomException{
        //check if pizzeria exists
        if(!pizzerias.containsKey(pizzeriaName)){
            throw CustomExceptionFactory.createException("pizzeriaNotFound",pizzaConfig);
        }
        pizzerias.forEach((key, value) -> {
            if (key.equalsIgnoreCase(pizzeriaName)) {
                this.pizzaConfig = (PizzaConfig) value;

                try {
                    this.pizzaConfig.updateOptionSet(optionSetName, newName);
                } catch (CustomException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //search the Model for the entry specified by the pizzeria name and update the base price to the value specified by newPric@Override
    public void updateBasePrice(String pizzeriaName, double newPrice) throws CustomException{
        if(!pizzerias.containsKey(pizzeriaName)){
            throw CustomExceptionFactory.createException("pizzeriaNotFound",null);
        }
        pizzerias.forEach((key, value) -> {
            if (key.equalsIgnoreCase(pizzeriaName)) {
                this.pizzaConfig = (PizzaConfig) value;
                try {
                    this.pizzaConfig.setBasePrice(newPrice);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //search the Model for the entry specified by the pizzeria name and update the Option in the given OptionSet to have the price specified by newPrice@Override
    public void updateOptionPrice(String pizzeriaName, String optionSetName, String option, double newPrice) throws CustomException{
        if(!pizzerias.containsKey(pizzeriaName)){
            throw CustomExceptionFactory.createException("pizzeriaNotFound",null);
        }
        pizzerias.forEach((key, value) -> {
            if (key.equalsIgnoreCase(pizzeriaName)) {
                this.pizzaConfig= (PizzaConfig) value;
                try {
                    pizzaConfig.updateOption(optionSetName,option,option, newPrice);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    //delete pizzeria from the list
    public  void deletePizzeria(String pizzeriaName) throws CustomException{
        if(!pizzerias.containsKey(pizzeriaName)){
            throw CustomExceptionFactory.createException("pizzeriaNotFound",null);
        }
        pizzerias.remove(pizzeriaName);
    }

}
