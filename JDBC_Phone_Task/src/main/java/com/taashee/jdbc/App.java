package com.taashee.jdbc;
import java.util.*;




import com.taashee.jdbc.dao.PhoneDAO;
public class App 
{
	static PhoneDAO phnDAO=new PhoneDAO();
    public static void main( String[] args )
    {
    	launchJDBCAppConsole1();
    }
    private static void launchJDBCAppConsole1(){
        System.out.println("Welcome to Phone database");
        String inp="0";
        Scanner sc =new Scanner(System.in);
        while(inp!="-1")
        {
               System.out.println("\nSelect the task you wish to perform");
               System.out.println("1.Fetch all phones");
               System.out.println("2.Get phones by name");
               System.out.println("3.Insert a new phone");
               System.out.println("4.Update phone");
               System.out.println("5.Delete phone");
               System.out.println("6.Search phones");
               System.out.println("-1.Exit");
               inp = sc.nextLine();
               switch(inp)
               {
                 case "1": 
                	   phnDAO.getAllPhones();
       		           break;
                	 
                 case "2":
                	 System.out.println("Enter name of the phone:");
          		     String name2=sc.nextLine();
          		     phnDAO.getPhoneByName(name2);
                	     break;
                 case "3":
                	 System.out.println("Enter name:");
        		     String name=sc.nextLine();
        		     System.out.println("Enter manufacturer:");
        		     String manu=sc.nextLine();
        		     phnDAO.addPhone(name,manu);
                	     break;
                 case "4":
                	
               		  System.out.println("Enter phone id to be updated:");
               		  String id=sc.nextLine();
               		  System.out.println("Enter name:");
               		  String name1=sc.nextLine();
               		  System.out.println("Enter manufacturer:");
               		  String manu1=sc.nextLine();
               		  phnDAO.updatePhone(Integer.parseInt(id),name1,manu1);
                	     break;
                 case "5":
                	 System.out.println("Enter phone id to be deleted:");
          		     String id1=sc.nextLine();
          		     phnDAO.deletePhone(Integer.parseInt(id1));
                	    break;
                 case "6":
                	 System.out.println("Enter name:");
           		     String name3=sc.nextLine();
           		     System.out.println("Enter manufacturer:");
           		     String manu2=sc.nextLine();
           		     phnDAO.searchPhone(name3,manu2);
                	   break;
                 case "-1":
                	     System.out.println("Exited Succesfully");
                	     return;
                default:
                	 System.out.println("Enter valid option");
               }
        }
        sc.close();
    }
}
