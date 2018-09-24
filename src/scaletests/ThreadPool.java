package scaletests;

import wrapper.PizzeriaConfigAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    PizzeriaConfigAPI pizzeriaConfigAPI= new PizzeriaConfigAPI();
    ExecutorService executorService= Executors.newFixedThreadPool(3);
    public void test(){

        SimulatedUser simulatedUser1=new SimulatedUser(pizzeriaConfigAPI,"pizza1.txt",2400,"Full Pizza");
        ExecutorService pool= Executors.newFixedThreadPool(10);

        //Execute 10 times using 10 simulatedUser1 threads
        for (int i=0; i<10; i++){
            pool.submit(simulatedUser1);
        }
        pool.shutdown();
    }
}
