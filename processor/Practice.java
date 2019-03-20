/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;

/**
 *
 * @author Raje Abhilash Mohite
 */
public class Practice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        java.util.ArrayList<String> str = new java.util.ArrayList<>(50);
        System.out.println("Size : "+str.size());
        System.out.println("Empty : "+str.isEmpty());
        str.add("CDD");
        System.out.println("Size : "+str.size());
        str.remove(0);
        System.out.println("Empty : "+str.isEmpty());
        System.out.println("Size : "+str.size());
        str.add("DAC");
        System.out.println("Size : "+str.size());
        str.add("CAD");
        System.out.println("Size : "+str.size());
        str.add("CPP");
        System.out.println("Size : "+str.size());
        str.add("ABC");
        System.out.println("Size of Array List : "+str.size());
        System.out.println("Array List : "+str);
        for(int i=0;i<str.size();i++)
        {
            for(int j=i;j<str.size();j++)
            {
              //  System.out.println("Strings to Compare : "+str.get(i)+" and "+str.get(j));
                Thread.sleep(1);
                if(str.get(i).compareTo(str.get(j))>0)
                {                    
                    String temp;
                    temp = str.get(i);
                    str.set(i, str.get(j));
                    str.set(j, temp);
                }
            }
        }
        System.out.println("After Swapping : "+str+" Size : "+str.size());
       for(int k=0;k<str.size();k++)
        {
            System.out.println(str.get(k));
        }
       
        //    boolean remove = str.removeAll(str);
        str.remove(0);
        System.out.println("Size : "+str.size());
        //System.out.println(str.get(0));
        str.remove(0);
        System.out.println("Size : "+str.size());
        str.remove(0);
        System.out.println("Size : "+str.size());
        str.remove(0);
        System.out.println("Size : "+str.size());
        //str.remove(0);
        System.out.println("Size : "+str.size());
        System.out.println("List is Empty "+str.isEmpty());
        System.out.println(str);
        System.out.println("Size : "+str.size());
        
    }catch(InterruptedException e)
    {
        
    }
    }
}
