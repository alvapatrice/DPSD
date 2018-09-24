package wrapper;

import exceptions.CustomException;

public interface UpdatePizzeria {

    //search the Model for the entry specified by the model name for a given OptionSet and set the name of OptionSet to newName
    public void updateOptionSetName(String pizzeriaName, String optionSetName, String newName)throws CustomException;

    //search the Model for the entry specified by the pizzeria name and update the base price to the value specified by newPrice
    public void updateBasePrice(String pizzeriaName, double newPrice) throws CustomException;

    //search the Model for the entry specified by the pizzeria name and update the Option in the given OptionSet to have the price specified by newPrice.
    public void updateOptionPrice(String pizzeriaName, String optionName, String Option, double newPrice) throws CustomException;

    // delete a pizza from the list of pizzerias
    public void deletePizzeria(String pizzeriaName) throws CustomException;
}
