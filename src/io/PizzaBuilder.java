package io;

import exceptions.CustomException;
import exceptions.CustomExceptionFactory;
import model.PizzaConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PizzaBuilder {
    BufferedReader buff = null;
    public PizzaBuilder() {
    }

    //build pizza configurations from the file
    public PizzaConfig buildPizzaConfig(String fileName){
        PizzaConfig pizzaConfig=new PizzaConfig();
        try
        {
            FileReader file = new FileReader(fileName);
            buff = new BufferedReader(file);
            String line;
            line = buff.readLine();



            while (line != null)
            {

                String[] data= line.split(",");


                //get the first index and use it as a way to loop through the whole document
                String index=data[0];
                switch (index){
                    case "0":
                        //it is a pizza config, get pizza name and base price
                        if(data[1]!=null&&data[2]!=null){
                            pizzaConfig.setName(data[1]);
                            pizzaConfig.setBasePrice(Double.parseDouble(data[2]));
                        }else {
                            throw CustomExceptionFactory.createException("invalidLine",pizzaConfig);
                        }
                    case "1":
                        //it is an option set, get an option set name
                        if(data[1]!=null){
                            pizzaConfig.addOptionSet(data[1]);
                        }else {
                            throw CustomExceptionFactory.createException("invalidLine",pizzaConfig);
                        }
                        break;

                    case "2":
                        //it is an option, get option set name, option name and option price
                        if(data[1]!=null&&data[2]!=null&&data[3]!=null){
                            pizzaConfig.addOption(data[1],data[2],Double.parseDouble(data[3]));
                        }else {
                            throw CustomExceptionFactory.createException("invalidLine",pizzaConfig);
                        }
                        break;
                    default:
                        //throw invalid format exception
                        throw CustomExceptionFactory.createException("invalidFormat",pizzaConfig);
                }
                line = buff.readLine();
            }
            buff.close();
            pizzaConfig.printPizzaConfig();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return pizzaConfig;
    }
}
