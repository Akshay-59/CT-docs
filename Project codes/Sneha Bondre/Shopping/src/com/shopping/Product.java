package com.shopping;

import java.util.Scanner;


public class Product {
	
	
	public void getMobile() {

		Customer customer = new Customer();
		Scanner sc=new Scanner(System.in);
		int phoneOption;
		int ans=0;
		boolean exit = false;
		int bill = 0;
		int quantity = 0;
		
			do {
				 System.out.println("------------Phones--------\r\n"
				 		+ "1. Iphone12\r\n"
				 		+ "2. Iphone13\r\n"
				 		+ "3. Samsung X1\r\n"
				 		+ "4. Exit\r\n"
				 		+ "-------------------------");
				 
				 System.out.println("Select Phone");
				 phoneOption=sc.nextInt();
				 switch (phoneOption) {
			       case 1:
			    	   System.out.println("Enter the Quantity of Iphone 12:");
			    	   quantity=sc.nextInt();
			    	   bill=54000;
			    	   System.out.println("Your bill is:"+(bill*quantity)); 
			    	   System.out.println("Do you want to continue?");
			    	   System.out.println("1.Yes");
			    	   System.out.println("2.No");
			    	   ans = sc.nextInt();
			    	   if(ans==1) {
			    		   Common common = new Common();
			    		  
			    	   }
			    	   else {
  			    	 		System.out.println("Exited");
  			    	 		break;
  			    	 	}
  					   break;
			       case 2:
			    	   	System.out.println("Enter the Quantity of Iphone 13 :");
   			    	 	quantity=sc.nextInt();
   			    	 	bill=72000;
   			    	 	System.out.println("Your bill is:"+(bill*quantity));
   			    	 	System.out.println("Do you want to continue?");
   			    	 	System.out.println("1.Yes");
			    	    System.out.println("2.No");
   			    	 	ans=sc.nextInt();
   			    	 	if(ans==1) {
   						Common common = new Common();
   			    	 	}
   			    	 	else {
   			    	 		System.out.println("Exited");
   			    	 		break;
   			    	 	}
   			    	 	break;
			       case 3:
			    	   	System.out.println("Enter the Quantity Samsung X1:");
   			    	 	quantity=sc.nextInt();
   			    	 	bill=22000;
   			    	 	System.out.println("Your bill is:"+(bill*quantity));
   			    	 	System.out.println("Do you want to continue?");
   			    	 	System.out.println("1.Yes");
   			    	 	System.out.println("2.No");
   			    	 	ans=sc.nextInt();
   			    	 	if(ans==1) {
   						Common common = new Common();
   			    	 	}
   			    	 	else {
			    	 		System.out.println("Exited");
			    	 	}
					 
   					 
			       case 4:
			    	   Common common = new Common();
			           break;
				 }
	            	}while(!exit);
		
	}
	
	public void getFurniture(){
		
	}
	
	public void getLaptop() {

		Customer customer = new Customer();
		Scanner sc=new Scanner(System.in);
		int laptopOption;
		int ans=0;
		boolean exit = false;
		int bill = 0;
		int quantity = 0;
		
			do {
				 System.out.println("------------Laptops-----------\r\n"
				 		+ "1. Imac\r\n"
				 		+ "2. HP\r\n"
				 		+ "3. Asus X1\r\n"
				 		+ "4. Exit\r\n"
				 		+ "-------------------------");
				 
				 System.out.println("Select Laptop");
				 laptopOption=sc.nextInt();
				 switch (laptopOption) {
			       case 1:
			    	   System.out.println("Enter the Quantity of Imacs:");
			    	   quantity=sc.nextInt();
			    	   bill=120000;
			    	   System.out.println("Your bill is:"+(bill*quantity)); 
			    	   System.out.println("Do you want to continue?");
			    	   System.out.println("1.Yes");
			    	   System.out.println("2.No");
			    	   ans = sc.nextInt();
			    	   if(ans==1) {
			    		   Common common = new Common();
			    		  
			    	   }
			    	   else {
  			    	 		System.out.println("Exited");
  			    	 		break;
  			    	 	}
  					 break;
			       case 2:
			    	   	System.out.println("Enter the Quantity of HP laptop :");
   			    	 	quantity=sc.nextInt();
   			    	 	bill=65000;
   			    	 	System.out.println("Your bill is:"+(bill*quantity));
   			    	 	System.out.println("Do you want to continue?");
   			    	 	System.out.println("1.Yes");
			    	    System.out.println("2.No");
   			    	 	ans=sc.nextInt();
   			    	 	if(ans==1) {
   						Common common = new Common();
   			    	 	}
   			    	 	else {
   			    	 		System.out.println("Exited");
   			    	 		break;
   			    	 	}
   			    	 	break;
			       case 3:
			    	   	System.out.println("Enter the Quantity Asus laptop:");
   			    	 	quantity=sc.nextInt();
   			    	 	bill=45000;
   			    	 	System.out.println("Your bill is:"+(bill*quantity));
   			    	 	System.out.println("Do you want to continue?");
   			    	 	System.out.println("1.Yes");
   			    	 	System.out.println("2.No");
   			    	 	ans=sc.nextInt();
   			    	 	if(ans==1) {
   						Common common = new Common();
   			    	 	}
   			    	 	else {
			    	 		System.out.println("Exited");
			    	 	}
					 
   					 
			       case 4:
			    	   
			           exit = true;
			           break;
				 }
	            	}while(!exit);	
		
		
	}
}
