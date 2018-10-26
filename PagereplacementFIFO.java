package javaapplication7;

import java.util.*;

public class PagereplacementFIFO {

    public static void main(String[] args) {
  
        int np;
        int hit=0,fault=0;
        int pgf;
        int k=0,avail=0,i,j;
        System.out.println("enter no of pages");
        Scanner sc = new Scanner(System.in);
        np=sc.nextInt();
         System.out.println("enter no of page fraame");
          pgf=sc.nextInt();
         int pg[]=new int[np];
         System.out.println("enter Page entries");
         for(i=0;i<np;i++)
         {
            pg[i]=sc.nextInt();
         }
         int pf[]=new int[pgf];
         for(i=0;i<np;i++)
         {
             avail=0;
             for(j=0;j<pgf;j++)
             {
                 if(pf[j]==pg[i])
                 { 
                     hit++;           
                    avail=1;
                 }
             }
                 if(avail==0)
                 {
                     pf[k]=pg[i];
                     fault++;
                     k=(k+1)%pgf;                     
                 }
             }
         
         System.out.println("hit"+hit);
         System.out.println("fault"+fault);
}
}
