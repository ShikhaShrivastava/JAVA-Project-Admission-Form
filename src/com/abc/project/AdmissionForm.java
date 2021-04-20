package com.abc.project;

import java.util.Scanner;


abstract class College
{
	Scanner scan = new Scanner(System.in);

	//Variables for Branch details with number of seats and fees

	static String branch[]= {"Computer science   ","Electronics        ","Mechanical         ","Civil              "};
	static int no_of_seats[] = {5,5,5,5};
	final int fees[]= {38000,40000,39000,41000};
	
	//Variables for student details
	
	String name[]= new String[5],city[]= new String[5],gender[]=new String[5];
	int age[]= new int[5],pincode[]= new int[5];
	long mob_no[]= new long[5];

	void landingPage()
	{
		
		System.out.println("Press 1 to know available seats and fees \nPress 2 to see enrolled student's information\nPress 0 to exit");
			int n=scan.nextInt();
		switch(n)
		{
		case 1: showBranchDetails();
				break;

		case 2:	studentDetails();
				break;

		case 0: exit();
				break;

		default: System.out.println("Wrong input!!! Please enter either 0 or 1");
				landingPage();
		}

	}
	void exit()
	{
		System.out.println("Thank you!!!");
		System.exit(0);
	}
	
	void displayOpenings()
	{
		System.out.println();
		System.out.println("\nPress 1 take admission \nPress 0 to exit");
		int m=scan.nextInt();
		switch(m)
		{
		case 1: takeAdmission();
				break;
		case 0: exit();
		break;
		default: System.out.println("Please select the right key");
				showBranchDetails();
		}
	}
	
	void submit()
	{
		System.out.println("Press 5 to submit your details\nPress 0 to cancel and exit");
		int n=scan.nextInt();
		switch(n)
		{
		case 5: System.out.println("You are registered successfully");
		seatallocation();
		break;

		case 0: exit();
		break;
		default: System.out.println("Wrong selection, please press the right key(either 0 or 5)");
		submit();
		}
	}

	abstract void takeAdmission();
	
	abstract void showBranchDetails();

	abstract void studentDetails();
	
	abstract void seatallocation();
	
	void navigate()
	{
		{
			String[] args = null;
			System.out.println("Do you want to take new admission or see enrolled students details?\nPress 1 for new admission\npress 2 for enrolled student's details\nPress 0 to exit");
			int n=scan.nextInt();
			switch(n)
			{
			
			case 1: AdmissionForm.main(args);
			break;
			
			case 2: studentDetails();
			break;
			
			case 0:exit();
			break;
			
			default:System.out.println("Wrong Selection,please select either 0 or 1");
			navigate();
		}
	}	
  }
}
abstract class Branch extends College
{
	int no_of_admissions=0;
	void takeAdmission()
	{   

			System.out.println("Please fill your details below");
		
		System.out.print("Name :  ");
		scan.nextLine();
		name[no_of_admissions]=scan.nextLine();
		System.out.println();

		System.out.print("Age:  ");
		age[no_of_admissions]=scan.nextInt();
		System.out.println();

		System.out.print("Gender(M/F):  ");
		scan.nextLine();
		gender[no_of_admissions]=scan.next();
		System.out.println();

		System.out.print("Mobile number(Max 10 digits):  ");
		mob_no[no_of_admissions]=scan.nextLong();
		System.out.println();

		System.out.print("city: ");
		scan.nextLine();
		city[no_of_admissions]=scan.nextLine();
		System.out.println();

		System.out.print("Pincode(max 6 digits):  ");
		pincode[no_of_admissions]=scan.nextInt();
		System.out.println();

		submit();
		
	}
	void studentDetails()
	{
		boolean flag=false;
		int seats=0;
		for(int i=0;i<=4;i++)
		{
			if(name[i]==null)
			{
				flag=true;
				seats=i;
				break;
			}
			else
			{
				System.out.println();
				System.out.println(name[i]+"   "+age[i]+"   "+gender[i]+"   "+mob_no[i]+"   "+city[i]+"   "+pincode[i]);
				System.out.println();
			}
		}
		if(flag==true)
		{
			System.out.println("\n-----------------------"+(4-seats+1)+" seats are available-----------------------\n");
			landingPage();
		}
	}
}
class ComputerScience extends Branch
{
	
	void showBranchDetails()
	{
			System.out.println("     Branch        seats    fees");
			System.out.println();
			System.out.print(branch[0]+"  ");
			System.out.print(no_of_seats[0]+"      ");
			System.out.print(fees[0]);
			displayOpenings();
	}
	void seatallocation()
	{
		--no_of_seats[0];
		++no_of_admissions;
		navigate();
	}
}
class Electronics extends Branch
{
	void showBranchDetails()
	{
		System.out.println("     Branch        seats    fees");
		System.out.println();
			System.out.print(branch[1]+"  ");
			System.out.print(no_of_seats[1]+"      ");
			System.out.print(fees[1]);
			displayOpenings();
	}
	void seatallocation()
	{
		--no_of_seats[1];
		++no_of_admissions;
		navigate();
	}
}

class Mechanical extends Branch
{
	void showBranchDetails()
	{
		System.out.println("     Branch        seats   fees");
		System.out.println();	
			System.out.print(branch[2]+"  ");
			System.out.print(no_of_seats[2]+"      ");
			System.out.print(fees[2]);
			displayOpenings();
	}
	void seatallocation()
	{
		--no_of_seats[2];
		++no_of_admissions;
		navigate();
	}
}

class Civil extends Branch
{
	void showBranchDetails()
	{
		System.out.println("     Branch        seats    fees");
		System.out.println();
			System.out.print(branch[3]+"  ");
			System.out.print(no_of_seats[3]+"      ");
			System.out.print(fees[3]);
			displayOpenings();
	}
	void seatallocation()
	{
		--no_of_seats[3];
		++no_of_admissions;
		navigate();
		}
	}


//APPLICATION CLASS

class AdmissionCell
{
	void admission(Branch ref)
	{
		ref.landingPage();
	}
}


public class AdmissionForm {
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		ComputerScience cs=new ComputerScience();
		Electronics ec=new Electronics();
		Mechanical mech=new Mechanical();
		Civil civil=new Civil();
		AdmissionCell ac=new AdmissionCell();
		
		System.out.println("____Welcome to admission cell____");
		System.out.println("\nPlease select a branch \n\nPress 1 for CS\nPress 2 for EC\nPress 3 for Mechanical\nPress 4 for Civil\nAre you afraid? then exit :D\n press 0 to exit");
			int n=scan.nextInt();
		switch(n)
		{
		case 1: ac.admission(cs);
			break;
		case 2: ac.admission(ec);
			break;
		case 3: ac.admission(mech);
			break;
		case 4: ac.admission(civil);
			break;
		case 0: exit();
		default:System.out.println("Wrong selection, Please select from given Options\n");
			main(args);
		}
		
			System.out.println("Wrong input,please select from 1,2,3 or 4\n");
			main(args);
			
		scan.close();
	}
	static void exit()
	{
		System.out.println("Thank you, see you soon!!!");
		System.exit(0);
	}

}
