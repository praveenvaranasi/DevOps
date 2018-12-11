package com.packages.app;

public class Add
{
   public int addition()
   {
	int a = 10;
	int b = 20;
	int result = a + b; 
        System.out.println("Result is: "+result);
	return result;
   }
   public static void main(String[] args)
   {
       Add obj = new Add();
       System.out.println(obj.addition());
   }
}
