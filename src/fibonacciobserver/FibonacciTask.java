package fibonacciobserver;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread
{

    private long tal;
    private long tempTal;
    List<FibonacciObserver> observers = new ArrayList();

    public void registerFibonacciObserver(FibonacciObserver o)
    {
        observers.add(o);
    }

    public FibonacciTask(long n)
    {
        this.tal = n;
    }

    @Override
    public void run()
    {
        //Call the Fibonacci method from here
        //long tal = ......
        System.out.println("tal "+tal);
        setTempTal(fib(tal));
        System.out.println("temptal "+tempTal);
        for (FibonacciObserver observer : observers)
        {
            observer.dataReady(tempTal);
        }
        

    }

    public long getFib()
    {
        return tal;
    }

    public void setTempTal(long n)
    {
        tempTal = n;
    }

    private long fib(long n)
    {
        if ((n == 0) || (n == 1))
        {

            return n;
        }
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
