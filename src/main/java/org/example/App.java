package org.example;

import org.example.homecost.*;
import org.example.interest.*;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.format("%s", "Enter I or i to calculate SI or CI \nEnter C or c to calculate cost of construction\n");
        String choice = sc.nextLine();
        switch(choice)
        {
            case "I" :
            case "i" :
                double principal,rate,time;
                int option;

                System.out.format("%s", "Enter Principal\n");
                principal = sc.nextDouble();

                System.out.format("%s", "Enter Rate Of Interest\n");
                rate = sc.nextDouble();

                System.out.format("%s", "Enter Time\n");
                time = sc.nextDouble();

                Interest ob = new Interest(principal,rate,time);

                System.out.format("%s","Enter 1 for SI and 2 for CI\n");
                option = sc.nextInt();

                if(option == 1)
                    System.out.format("%s",ob.calculate_SI());
                else if(option == 2)
                    System.out.format("%s",ob.calculate_CI());
                else
                    System.out.format("%s","Wrong choice");
                break;

            case "C" :
            case "c" :
                System.out.format("%s","Enter S or s for Standard Material\nEnter A or a for Above Standard Material\nEnter H or h for High Standard Material\n");
                String material = sc.next();

                System.out.format("%s", "Enter Total Area Of House\n");
                double area = sc.nextDouble();

                System.out.format("%s", "Want Fully Automated Home ? (True/False)\n");
                Boolean opt = sc.nextBoolean();
                Home home = new Home(material, area, opt);
                double cost = home.totalCost();
                if(cost == 0)
                {
                    System.out.format("Wrong Choice");
                }
                else {
                    System.out.format("%s","Total cost is "+cost);
                }
                break;

            default :
                System.out.format("%s", "Wrong Choice");
                break;
        }
    }
}