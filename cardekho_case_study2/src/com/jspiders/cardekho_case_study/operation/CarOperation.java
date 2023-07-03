package com.jspiders.cardekho_case_study.operation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Car> obj = new ArrayList<Car>();
	
	ArrayList<Car>Temp = new ArrayList<Car>();
	
	//-------New Add New Car Details--------
	public void Add_Car() 
	{
			
			Car AdCar = new Car();
			if (AdCar.get_Car_id() == 0 || AdCar.get_Car_name()==null || AdCar.get_Brand() == null || AdCar.get_fuel_type()== null || AdCar.get_price()==0) 
			{
				System.out.println("\nSome Data Is Missing Please Try Again !");
				Add_Car();
			} else {
				obj.add(AdCar);
			}
		 
	}
	
	public void addAutomatically()
	{
		obj.add(new Car(101,"SAFARI","TATA","PETROL",450000));
		obj.add(new Car(102,"NANO","TATA","DISEL",950000));
		obj.add(new Car(103,"BELENO","MARUTI","PETROL",650000));
		obj.add(new Car(104,"POLO","VOLSW","PETROL",850000));
	}
	
	//------------Remove Car ----------
	public  void Remove_Car() 
	{
		System.out.println("\nRemove Car By : ");
		int m = searchCarBy();
		
		if (!Temp.isEmpty()) {
			obj.removeAll(Temp);
			System.out.println("\nSuccesfully Deleted Data ! ");
		} 
		else if(Temp.isEmpty() && m<6 ) {
			System.out.println("Sorry Data Is Not Found ! Try Again Another Way  ");
			Remove_Car();
		}
		Temp.clear();
		
	}
	//-------------Search Car-----------
	public  void searchCar()
	{
		System.out.print(	"\nSEARCH CAR BY : \n");
		
		int num=searchCarBy(); 	
		
		if (num<6 && !Temp.isEmpty()) {
			displayBPlate();
			for (Car tvar : Temp)
			{
				tvar.displayCarDetails();
			}
		}
		else if(Temp.isEmpty()&& num!=6)
		{
			System.out.println("\nSorry Data Not Found Try Again !");
			searchCar();
		}
		
		Temp.clear();
	}
//------------------Display All Details ------------
	
	public  void displayBPlate() {
		System.out.println("\nID\t"+"Car_Name\t"+"Comp_Name\t"+"Fuel_Type\t"+"Price ");
		System.out.println("======================================================================");
	}
	
	public  void displayADetails()
	{
		displayBPlate();
		for(Car var : obj)
		{
			var.displayCarDetails();
		}
		
	}
	//------------------Get User Input Choice Code ------------------
	 int s;
	 int Cnum;
	public  int get_Choice()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Choice : ");
		s=0;
		try {
			Cnum= sc.nextInt();
			
			
		} catch (InputMismatchException e) {
			System.out.println("\n#############--Enter Only Integer Value !--############ \n Try Again ! ");
			s++;
		}
		
		while (s!=0) 
		{
			get_Choice();
		}
		
		return Cnum;
	
	}
	//------------------------Update Car Details ------------------
	
	public  void updateCarDetails()
	{
		
		displayADetails();
		
		System.out.print("\nUpdate Data By :  ");
		
		int a= searchCarBy(); 
		
		
		if (Temp.isEmpty() && a!=6) {
			System.out.println("\nData Not Found Please  try Again !");
			updateCarDetails();
		}
		else if(a!=6) {
			displayBPlate();
			for(Car Ddata : Temp)
			{
				Ddata.displayCarDetails();
			}
		}
		
		
		if (a<6) {
			switch(a)
			{
			case 1 :{
				System.out.print("\nEnter Your Updated Value for id : " );
				int m = sc.nextInt();
				for(Car Ddata : Temp)
				{
					Ddata.set_Car_id(m);
				}
				break;
				
			}
			case 2 :{
				System.out.print("\nEnter Your Updated Value for Car Name : " );
				String Cname = sc.next();
				for(Car Ddata : Temp)
				{
					Ddata.set_Car_name(Cname);
				}
				break;
			}
			case 3 :{
				System.out.print("\nEnter Your Updated Value for Company Name: " );
				String Cname = sc.next();
				for(Car Ddata : Temp)
				{
					Ddata.set_Brand(Cname);
				}
				break;
			}
			case 4 :{
				System.out.print("\nEnter Your Updated Value for Fuel Type : " );
				String Cname = sc.next();
				for(Car Ddata : Temp)
				{
					Ddata.set_fuel_type(Cname);
				}
				break;
				
			}
			case 5 :{
				System.out.print("\nEnter Your Updated Value for Price : " );
				double num = sc.nextInt();
				for(Car Ddata : Temp)
				{
					Ddata.set_price(num);
				}
				break;
			}
			
			default:{
				break;
			}
			
			}
			displayBPlate();
			for(Car Ddata : Temp)
			{
				Ddata.displayCarDetails();
			}
		
		System.out.println("\n=======Your value Will Be Updated successfully !========");
		displayBPlate();
		for(Car Ddata : Temp)
		{
			Ddata.displayCarDetails();
		}
		
		Temp.clear();
		}
		
		
		
		}
	
	public int searchCarBy()
	{
		System.out.print(
			    "\n1.CAR ID  \n"+
				"2.CAR NAME \n"+
			    "3.Company Name \n"+
				"4.Fuel Type \n"+
			    "5.Price\n"+
				"6.Back To Main Menu\n");
		int k = get_Choice();
		switch (k) {
		case 1:
				{
					System.out.print("\nEnter Car Id :");
					int Cid= sc.nextInt();
					for(Car var : obj)
					{
						if (var.get_Car_id()==Cid) {
							Temp.add(var);
						}
					}
					break;
				}
		case 2:
				{
					System.out.print("\nEnter Car Name :");
					String Cname= sc.next();
					for(Car var : obj)
					{
						if (var.get_Car_name().equalsIgnoreCase(Cname)) {
							Temp.add(var);
						}
					}
					break;
				}
		case 3:
				{
					System.out.print("\nEnter Company Name :");
					String Cname= sc.next();
					for(Car var : obj)
					{
						if (var.get_Brand().equalsIgnoreCase(Cname)) {
							Temp.add(var);
						}
					}
					break;
				}
		case 4:
				{
					System.out.print("\nEnter Fuel Type  :");
					String Ftype= sc.next();
					for(Car var : obj)
					{
						if (var.get_fuel_type().equalsIgnoreCase(Ftype)) {
							Temp.add(var);
						}
					}
					break;
				}
		case 5:
				{
					System.out.print("\nEnter Price :");
					double Cpri= sc.nextInt();
					for(Car var : obj)
					{
						if (var.get_price()==Cpri) {
							Temp.add(var);
						}
					}
					break;
				}
		case 6 :
				{
					break;
				}
		
		default:
				{
					System.out.println("\nWrong Choice Try Again ! ");
					searchCarBy();
					break;
				}
		}
		return k;
		
	}
	
	
	
}
