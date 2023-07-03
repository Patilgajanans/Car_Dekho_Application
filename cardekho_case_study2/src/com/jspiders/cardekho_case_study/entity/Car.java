package com.jspiders.cardekho_case_study.entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Car {
	private int car_id;
	private String car_name;
	private String Brand;
	private String fuel_type;
	private double price;
	
	
	//=======helper method=======
	
	//-----------Setter Method-------------------
	public void set_Car_id(int a)
	{
		this.car_id = a;
	}
	
	public void set_Car_name(String a)
	{
		this.car_name = a;
	}
	
	public void set_Brand(String a)
	{
		this.Brand = a;
	}
	
	public void set_fuel_type(String a)
	{
		this.fuel_type = a;
	}
	
	public double set_price(double a)
	{
		return this.price=a ;
	}
	
	public int get_Car_id()
	{
		return this.car_id;
	}
	
	
	//----------------getter method--------------
	public String get_Car_name()
	{
		return this.car_name;
	}
	
	public String get_Brand()
	{
		return this.Brand;
	}
	
	public String get_fuel_type()
	{
		return this.fuel_type;
	}
	
	public double get_price()
	{
		return this.price;
	}
	
	public Car() 
	{
		try {
			Scanner sc =new Scanner(System.in);
			System.out.print("\nEnter Your Car Id                 : ");
			this.car_id=sc.nextInt();
			System.out.print("Enter Your Car Name               : ");
			this.car_name=sc.next();
			System.out.print("Enter Your Car Company Name(Brand): ");
			this.Brand=sc.next();
			System.out.print("Enter Car Fuel Type               : ");
			this.fuel_type=sc.next();
			System.out.print("Enter Car price                   : ");
			this.price=sc.nextDouble();
			System.out.println("\n---------------"+this.car_name + " Added SucessFully In DataBase --------------");
			
		} catch (InputMismatchException e) {
			System.out.println("\n####### Wrong Data Enterd Please ! #######");
			System.out.println("\n******* Id & Price Take Only Integer Value ******* ");
		}
		
	}
	
	public Car(int a,String b,String c,String d,double p)
	{
		this.car_id=a;
		this.car_name=b;
		this.Brand=c;
		this.fuel_type=d;
		this.price=p;
	}
	//-------------------Display Details-------------
	public void displayCarDetails()
	{
		System.out.println(this.car_id+"\t"+this.car_name+"\t\t"+this.Brand+"\t\t"+this.fuel_type+"\t\t"+this.price);
	}
	
	public String toSting()
	{
		String id = String.valueOf(this.car_id);
		return id;
	}

	}
	
	

