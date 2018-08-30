
package javaapplication1;
import java.io.*;
import java.util.*;
class A
{
    int mutex=1;
    int e =5;
    int f=0;
    int temp;
A()
{
    int ch;
    while(true)
    {
        System.out.println("1.producer 2.consumer 3.exit");
        Scanner sc = new Scanner(System.in);
        ch=sc.nextInt();
        switch(ch)
        {
            case 1 : if(mutex==1 && f!=5)
                producer();
                    else
                    System.out.println("producer waiting");
            break;
            
            case 2 : if(mutex==1 && e!=5)
                consumer();
                     else
                    System.out.println("consumer waiting");
            break;
            
            case 3 : System.exit(0);
            break;
        }
    }
}
int wait(int s)
{
    --s;
    return s;
}
int signal(int s)
{
    ++s;
    return s;
}
void producer()
{
    mutex = wait(mutex);
    f=signal(f);
    e= wait(e);
    System.out.println("produced item");
    mutex = signal(mutex);
}
void consumer()
{
    mutex = wait(mutex);
    f=wait(f);
    e= signal(e);
    System.out.println("consumed item");
    mutex = signal(mutex);
}
}

public class producerconsumer
{

   
    public static void main(String[] args) {
       new A();
    }
    
}
