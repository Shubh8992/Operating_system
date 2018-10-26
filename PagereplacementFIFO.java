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
         System.out.println("enter values");
         for(i=0;i<np;i++)
         {
            pg[i]=sc.nextInt();
         }
         int pf[]=new int[pgf];
         System.out.println("                                 PageFrames");
         for(i=0;i<np;i++)
         {
             avail=0;
             System.out.print("page entry "+pg[i]+"          ");
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
                 for(j=0;j<pgf;j++)
                 System.out.print("   "+pf[j]+"     ");
                 System.out.println("");
             }
         
         System.out.println("hit ="+hit);
         System.out.println("fault ="+fault);
}
}
