package com.vamsi.maven_oop;


import java.io.*;
import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        List<Sweet> sweetlist = new ArrayList();
        sweetlist.add(new Chocolate("DairyMilk",180,200.0f,62));
        sweetlist.add(new Chocolate("KitKat",20,50.5f,50));
        sweetlist.add(new Chocolate("MilkyBar",10,20.4f,40));
        sweetlist.add(new Chocolate("FerreroRocher",200,180.7f,75));
        sweetlist.add(new Jelly("JustJelly",30,20.6f,25));
        sweetlist.add(new Jelly("JollyRancher",20,15.6f,20));
        sweetlist.add(new Jelly("JellyBelly",50,20.6f,65));
        sweetlist.add(new Candy("Hershey's Kisses",60,8.1f,90));
		sweetlist.add(new Candy("LaffyTaffy",90,30.1f,75));
		sweetlist.add(new Candy("Nerds",10,2.6f,10));
		sweetlist.add(new Candy("MilkyWay",30,15.6f,25));
		sweetlist.add(new Candy("DoubleBubbleGum",5,3.0f,15));
		
		List<Sweet> chocolatelist = new ArrayList();
		float totalWeight=0.0f;
		for(int i=0;i<sweetlist.size();i++) {
			totalWeight+=sweetlist.get(i).weight;
		}
		System.out.println("Total weight of Gift is :"+totalWeight);
		for(int i=0;i<sweetlist.size();i++) {
			if(sweetlist.get(i) instanceof Chocolate) {
				chocolatelist.add(sweetlist.get(i));
			}
		}
		System.out.print("Enter the Option :\n1.sortByCost\n2.sortByWeight\n3.sortBySweetness\n4.don't sort\n");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				Collections.sort(chocolatelist,(a,b)->a.cost-b.cost);
				break;
			case 2:
				Collections.sort(chocolatelist,(a,b)->Float.compare(a.weight,b.weight));
				break;
			case 3:
				Collections.sort(chocolatelist,(a,b)->a.sweetness-b.sweetness);
				break;
		}
		System.out.println("Chocolates Present in the Gift are:");
		System.out.printf("\n%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
		for(int i=0;i<chocolatelist.size();i++){
			System.out.printf("%-15s %3d %8.4f %6d\n\n",chocolatelist.get(i).name,chocolatelist.get(i).cost,chocolatelist.get(i).weight,chocolatelist.get(i).sweetness);
			
		}
		System.out.println("Do you Want List of Candies(y/n)");
		char c=sc.next().charAt(0);
		if(c=='y'||c=='Y'){
			System.out.print("Enter the Option :\n1.Cost\n2.Weight\n3.Sweetness\n");
			choice=sc.nextInt();
			System.out.println("Enter the Range");
			int min=sc.nextInt();
			int max=sc.nextInt();
			System.out.printf("%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
			Sweet curr;
			int f=0;
			if(choice==1) {
				for(int i=0;i<sweetlist.size();i++) {
					curr=sweetlist.get(i);
					if(curr instanceof Candy && curr.cost>=min && curr.cost<=max){
						f=1;
						System.out.printf("%-15s %3d %8.2f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with cost of given range is not available");
			}
			else if(choice==2) {
				for(int i=0;i<sweetlist.size();i++) {
					curr=sweetlist.get(i);
					if(curr instanceof Candy && curr.weight>=min && curr.weight<=max){
						f=1;
						System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with weight of given range is not available");
			}
			else {
				for(int i=0;i<sweetlist.size();i++) {
					curr=sweetlist.get(i);
					if(curr instanceof Candy && curr.sweetness>=min && curr.sweetness<=max){
						f=1;
						System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with sweetness of given range is not available");
			}
		}
		sc.close();
    }

}
