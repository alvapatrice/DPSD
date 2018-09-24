package model;

import exceptions.CustomException;
import exceptions.CustomExceptionFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class PizzaConfig implements Serializable {

    //pizza config name
    private String name;

    //pizza base price, single pizza with cheese
    private Double basePrice;

    //Pizza option sets(Price, size, delivery mode, vegetable choices, meat choice, cheese choice)
    private ArrayList<OptionSet> optionSets= new ArrayList<>();

    public PizzaConfig(String name, Double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public PizzaConfig(String name) {
        this.name = name;
    }

    public PizzaConfig(Double basePrice) {
        this.basePrice = basePrice;
    }

    public PizzaConfig() {
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) throws CustomException {
        if(basePrice<0){

            throw CustomExceptionFactory.createException("invalidPrice",this);
        }
        this.basePrice = basePrice;
    }

    public ArrayList<OptionSet> getOptionSets() {
        return optionSets;
    }
    private OptionSet getOptionSet(String name){
        OptionSet optionSet= null;
        for (int i=0; i<optionSets.size(); i++){
            if(optionSets.get(i).getName().equalsIgnoreCase(name)){
               optionSet=optionSets.get(i);
               break;
            }
        }
        return optionSet;
    }
    public synchronized void addOptionSet(String name) throws CustomException{

        //check for duplicates
        OptionSet optionSet= getOptionSet(name);
        if(optionSet!=null){
            throw CustomExceptionFactory.createException("duplicateOptionSet",this);
        }

        optionSet= new OptionSet(name);
        optionSets.add(optionSet);
    }

    public synchronized void addOption(String optionSetName, String optionName, double optionPrice)throws CustomException{

        //find option set
        OptionSet optionSet= getOptionSet(optionSetName);

        if(optionSet==null){
            throw CustomExceptionFactory.createException("optionSetNotFound",this);
        }else {
            optionSet.addOption(optionName,optionPrice);
        }
    }
    //find an option set
    public HashMap findOptionSet(String optionSetName){
        HashMap<String, Object> optionSetMap= new HashMap<>();
        OptionSet optionSet=getOptionSet(optionSetName);
        if(optionSet!=null){
            optionSetMap.put("optionSetName",optionSet.getName());
            optionSetMap.put("Options",optionSet.getOptions().toString());
            return optionSetMap;
        }else{
            return null;
        }
    }

    //find option in an option set
    public HashMap findOption(String optionSetName, String optionName){
        HashMap<String,Object> optionMap= new HashMap<>();
        OptionSet.Option option=null;
        OptionSet optionSet= getOptionSet(optionSetName);

        if(optionSet!=null){
            option=optionSet.findOption(optionName);
        }
        if(option!=null){
            optionMap.put("optionName",option.getName());
            optionMap.put("optionPrice",option.getPrice());
            return optionMap;
        }else{
            return null;
        }
    }

    //update option set
    public synchronized void updateOptionSet(String oldName, String newName)throws CustomException{
        OptionSet optionSet=getOptionSet(oldName);
        //avoid duplicates
        if (optionSet!=null){
            if(getOptionSet(newName)==null){
                optionSet.setName(newName);
            }
        }else {
            throw CustomExceptionFactory.createException("duplicateOptionSet",this);

        }

    }

    //update option
    public synchronized void updateOption(String optionSetName, String oldOptionName, String newOptionName, double optionPrice)throws CustomException{
        OptionSet optionSet=getOptionSet(optionSetName);
        if(optionSet!=null){
            optionSet.updateOption(oldOptionName,newOptionName,optionPrice);
        }
    }

    //delete option set
    public synchronized void deleteOptionSet(String name){
        for (int i=0; i<optionSets.size(); i++){
            if(optionSets.get(i).getName().equalsIgnoreCase(name)){
                optionSets.remove(i);
                break;
            }
        }
    }

    //delete option
    public synchronized void deleteOption(String optionSetName, String optionName){
        OptionSet optionSet=getOptionSet(optionSetName);
        optionSet.deleteOption(optionName);
    }
    //print Pizza config
    public void printPizzaConfig(){
        System.out.println(toString());
    }

    //Validate pizza configuration
    public boolean validate(){
        if(getName()!=null||!getName().equals("")){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer= new StringBuffer();
        stringBuffer.append("Name: ");
        stringBuffer.append(name);
        stringBuffer.append("\nBase price: ");
        stringBuffer.append(basePrice+" Rwf");
        stringBuffer.append("\nOptions: \n\t");
        for (int i=0; i<optionSets.size(); i++){
                stringBuffer.append(optionSets.get(i).toString());

        }

        return stringBuffer.toString();
    }

}
