package scaletests;

import wrapper.PizzeriaConfigAPI;

public class MultithreadTest {
    private PizzeriaConfigAPI pizzeriaConfigAPI;
    public void test(){
        pizzeriaConfigAPI= new PizzeriaConfigAPI();
        SimulatedUser simulatedUser1=new SimulatedUser(pizzeriaConfigAPI,"pizza1.txt",2400,"Full Pizza");
        SimulatedUser simulatedUser2= new SimulatedUser(pizzeriaConfigAPI,"pizza2.txt",300,"Basic pizza");
        SimulatedUser simulatedUser3= new SimulatedUser(pizzeriaConfigAPI,"pizza3.txt",8909,"Complete pizza");

        new Thread(simulatedUser1, "user 1").start();
        new Thread(simulatedUser2,"user2").start();
        new Thread(simulatedUser3, "user3").start();
    }
}
