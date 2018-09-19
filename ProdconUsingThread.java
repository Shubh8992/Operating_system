
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProdconUsingThread {
 public static void main(String args[])
 {
     ArrayList<Integer> b = new ArrayList<Integer>();
     Thread ob1 =  new Thread(new Producer(b));
     Thread ob2 =  new Thread(new Consumer(b));
     
     ob1.start();
     ob2.start();
 }
}

class Producer implements Runnable
{
    List<Integer> b = null;
    final int maxsize=5;
    int i = 0;
    Producer(List<Integer> b)
    {
        this.b = b;
    }
    public void produce(int i) throws InterruptedException
    {
        synchronized(b)
                {
                    while(b.size()==maxsize)
                    {
                        System.out.println("producer waiting");
                        b.wait();
                    }    
                }
        synchronized(b)
        {
            b.add(i);
            System.out.println("producing...");
       Thread.sleep(1000);
            b.notify();
        }
    }
    public void run()
    {
        while(true)
        {
            i++;
            try {
                produce(i);
            } catch (InterruptedException ex) {
             
            }
        }
    }
}

class Consumer implements Runnable
{
    List<Integer> b;
    
    Consumer(List<Integer> b)
    {
         this.b = b;
    }
     public void consume() throws InterruptedException
    {
        synchronized(b)
                {
                    while(b.isEmpty())
                    {
                        System.out.println("consumer waiting");
                        b.wait();
                    }    
                }
        synchronized(b)
        {
            b.remove(0);
            System.out.println("consuming...");
            Thread.sleep(1000);
            b.notify();
        }
    }
    public void run()
    {
        while(true)
        {
            
            try {
                consume();
            } catch (InterruptedException ex) {
             
            }
        }
    }
}
