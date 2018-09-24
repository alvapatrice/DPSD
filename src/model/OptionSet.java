package model;

import exceptions.CustomException;
import exceptions.CustomExceptionFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable {
    //option set name
    private String name;

    //options list
    private ArrayList<Option> options=new ArrayList<>();

    protected OptionSet(String name, ArrayList<Option> options) {
        this.name = name;
        this.options = options;
    }

    protected OptionSet(String name) {
        this.name = name;
    }

    protected OptionSet(ArrayList<Option> options) {
        this.options = options;
    }

    protected OptionSet() {
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected ArrayList<Option> getOptions() {
        return options;
    }

    protected void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    //find option by name
    protected Option findOption(String name){
        Option foundOption=null;
        for(int i=0; i<options.size(); i++){
            if(options.get(i).name.equalsIgnoreCase(name)){
                foundOption=options.get(i);
                break;
            }
        }
        return foundOption;
    }

    //delete an option by name
    protected void deleteOption(String name){
        for(int i=0; i<options.size(); i++){
            if(options.get(i).name.equalsIgnoreCase(name)){
                options.remove(i);
                break;
            }
        }
    }

    //update an option
    protected void updateOption(String oldOptionName, String newOptionName, double optionPrice) throws CustomException{

        Option currentOption= findOption(oldOptionName);

        //check if the option exists and avoid duplication
        if(currentOption==null){

            throw CustomExceptionFactory.createException("optionNotFound",null);

        }else if(findOption(newOptionName)!=null&&!oldOptionName.equalsIgnoreCase(newOptionName)){
            throw CustomExceptionFactory.createException("optionDuplicate",null);
        }else{
            currentOption.setName(newOptionName);
            currentOption.setPrice(optionPrice);
        }
    }

    //add option
    protected void addOption(String optionName, double optionPrice) throws CustomException{
        Option option1=findOption(optionName);

        //check if the option exists and avoid duplications
        if(option1!=null){

            throw CustomExceptionFactory.createException("optionDuplicate",null);
        }
        Option option= new Option(optionName,optionPrice);
        options.add(option);
    }

    //print option set
    protected void print(){

    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nName :");
        stringBuffer.append(name);
        stringBuffer.append("\n\tChoices: ");
        for(int i=0; i<options.size(); i++){
                stringBuffer.append(options.get(i).toString());
        }
        return stringBuffer.toString();
    }



    public class Option implements Serializable {

        //Option's name()
        private String name;

        //Additional amount to the base price
        private Double price;

        protected Option(String name, Double price){
            this.name=name;
            this.price=price;
        }

        //getters and setters
        protected String getName() {
            return name;
        }

        protected void setName(String name) {
            this.name = name;
        }

        protected Double getPrice() {
            return price;
        }

        protected void setPrice(Double price) {
            this.price = price;
        }

        //print the option
        protected void print(){

        }

        @Override
        public String toString() {
            StringBuffer stringBuffer=new StringBuffer();
            stringBuffer.append("\n\t\tName: ");
            stringBuffer.append(name);
            stringBuffer.append("\n\t\tAdd price: ");
            stringBuffer.append(price+" Rwf\n\n\t");
            return stringBuffer.toString();
        }
    }
}
