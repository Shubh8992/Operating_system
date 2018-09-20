
package javaapplication2;
import java.util.*;
import java.io.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



public class RWP {

    
    static int rc=0;
    static Semaphore s = new Semaphore(1);
    static Semaphore wrt = new Semaphore(1);
    
    public static void main(String[] args) {
        while(true){
        Reader r = new Reader();
        Writer w = new Writer();
        Thread t1= new Thread(r);
        Thread t2= new Thread(r);
        Thread t3= new Thread(r);
        Thread t4= new Thread(w);
        Thread t5= new Thread(w);
        Thread t6= new Thread(w);
       t1.setName("Reader 1");
       t2.setName("Reader 2");
       t3.setName("Reader 3");
       t4.setName("writer 1");
       t5.setName("writer 2");
       t6.setName("writer 3");
       
       t1.start();
       t2.start();
       t3.start();
       t4.start();
       t5.start();
       t6.start();}
    }
    
    static public class Reader implements Runnable
    {
    
    public void run()
    {
        try {
            
            s.acquire();
            rc++;
            if(rc==1)
            wrt.acquire();
                s.release();
                System.out.println(Thread.currentThread().getName()+" is reading  ");
                Thread.sleep(1000);
                System.out.println("Reading finished...");
                //s.acquire();
                rc--;
            
            if(rc==0)
            {
                wrt.release();
                s.release();
            }
            
        } catch (InterruptedException ex) {
           
        }  
    }
    
}
static public class Writer implements Runnable
    {
    
    public void run()
    {
        try {
            wrt.acquire();
                System.out.println(Thread.currentThread().getName()+" is writing ");
                Thread.sleep(10);
                System.out.println("Writing finished...");
                        
                wrt.release();
            
        } catch (InterruptedException ex) {
           
        }  
    }
    
}
}

