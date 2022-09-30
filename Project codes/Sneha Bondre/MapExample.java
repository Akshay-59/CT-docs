package com.shpooingapp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MapExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> countryInfo = new HashMap<String, String>();
		countryInfo.put("India", "Delhi");
		countryInfo.put("Japan", "Tokyo");
		
		
		System.out.println("----Menu----");
		System.out.println("1. Country");
		System.out.println("2. Capital");
		System.out.println("0. Exit");
		
		int option = sc.nextInt();
		if(option==1) {
			System.out.println("Enter the name of the Country");
			String country = sc.next();
			for(Map.Entry<String, String>entry:countryInfo.entrySet()) {
				if(entry.getKey().equals(country))
				System.out.println("Name of Capital ="+entry.getValue());
			}
		}
		else if(option==2) {
			System.out.println("Enter the name of the Capital");
			String capital = sc.next();
			for(Map.Entry<String, String>entry:countryInfo.entrySet()) {
				if(entry.getValue().equals(capital))
				System.out.println("Name of Country ="+entry.getKey());
			}
		}
		else {
			System.out.println("Exited");
		}
		
	}
		
}
