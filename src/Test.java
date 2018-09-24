import io.PizzaBuilder;
import scaletests.MultithreadTest;
import scaletests.SimulatedUser;
import scaletests.ThreadPool;
import wrapper.PizzeriaConfigAPI;

public class Test {
    public static void main(String[] args){
        MultithreadTest multithreadTest=new MultithreadTest();
        multithreadTest.test();

        ThreadPool threadPool= new ThreadPool();
        //threadPool.test();

    }
}
