package com.packages.app;

import com.packages.app.Add;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	Add obj = new Add();
	System.out.println(obj.addition());
    }
}
