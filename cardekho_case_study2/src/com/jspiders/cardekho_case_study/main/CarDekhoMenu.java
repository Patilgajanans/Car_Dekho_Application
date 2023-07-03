package com.jspiders.cardekho_case_study.main;


import java.util.InputMismatchException;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.operation.CarOperation;

	public class CarDekhoMenu {
		{
			System.out.println("CarDekhoMenu");
		}
		
		static Scanner sc = new Scanner(System.in);
		static CarOperation Cop = new CarOperation();
		public static void mainMenu()
		{
			System.out.println("\n========MENU========\n"+
                	"1.Add/Remove Car\n"+
					"2.Update Car Details\n"+
					"3.Search Car Details\n"+
					"4.Display All Car Details\n"+
					"5.Exit");
			switch (Cop.get_Choice()) {
			case 1:{
				addRemove();
				mainMenu();
				break;
			}	
			case 2:{
				Cop.updateCarDetails();
				mainMenu();
				break;							
			}
			case 3:{
				Cop.searchCar();
				mainMenu();
				break;				
			}
			case 4:{
				Cop.displayADetails();
				mainMenu();
			}
			case 5:{
				return;			
			}
			default:
			{
				System.out.println("Wrong Choice Please Select Right One ! ");
				mainMenu();
			}
			}
			
		}
		public static void addRemove() throws InputMismatchException
		{
			System.out.println("\n========MENU=======\n"+
                	"1.Add Car Details\n"+
					"2.Remove Car Details\n"+
					"3.Back to main Menu");
					
			switch (Cop.get_Choice()) {
			case 1:{
				System.out.print("\nHow Many Car Do You Want To Add : ");
				int Count = sc.nextInt();
				while(Count>0)
				{
					Cop.Add_Car();
					Count--;
				}
				
				break;
			}
			case 2:{
				Cop.Remove_Car();
				break;
			}
			case 3:{
				mainMenu();
				break;
			}
			default :
			{
				System.out.println("\n #### Wrong Choice Please Try Again ! ####");
				addRemove();
			}
			}
		}
	
		public static void main(String[] args) {
			
			System.out.println("\n++++++++ Welcome To Car DeKho Application ++++++++\n\nPlease Select One Option  ");
			Cop.addAutomatically();   //For Check The Operations Add 4 CAr Automatically
			mainMenu();
			System.out.println("\n=========  Thank You  For Your Valuable Time ! ==========");
			}
}
