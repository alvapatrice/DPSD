package scaletests;

import exceptions.CustomException;
import wrapper.PizzeriaConfigAPI;

public class SimulatedUser implements Runnable {

    PizzeriaConfigAPI pizzeriaConfigAPI;
    String fileName;
    double basePrice;
    String pizzaName;

    public SimulatedUser(PizzeriaConfigAPI pizzeriaConfigAPI) {
        this.pizzeriaConfigAPI=pizzeriaConfigAPI;
    }

    public SimulatedUser(PizzeriaConfigAPI pizzeriaConfigAPI, String fileName, double basePrice, String pizzaName) {
        this.pizzeriaConfigAPI = pizzeriaConfigAPI;
        this.fileName = fileName;
        this.basePrice = basePrice;
        this.pizzaName = pizzaName;
    }

    @Override
    public void run() {
        String msg=Thread.currentThread().getName();


        try {
            //create pizzeria
            System.out.println("------------Thread "+msg+" is creating----------");
            pizzeriaConfigAPI.configurePizzeria(fileName);

            //update pizzeria
            System.out.println("------------Thread "+msg+" is updating-----------");
            pizzeriaConfigAPI.updateBasePrice(pizzaName,basePrice);

            //print pizzeria list
            System.out.println("------------Thread "+msg+" is printing-----------");
            pizzeriaConfigAPI.printPizzeria();

            //delete pizzeria
            System.out.println("------------Thread "+msg+" is deleting------------");
            pizzeriaConfigAPI.deletePizzeria(pizzaName);

            System.out.println("------------Thread "+msg+" is printing after deletion----------");
            pizzeriaConfigAPI.printPizzeria();
        }catch (CustomException e){
            try {
                e.handleException();
            } catch (CustomException e1) {
                e1.printStackTrace();
            }
        }

    }
}
