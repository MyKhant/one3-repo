package com.shop.util;

import java.util.Scanner;

public class ShopUtil {
	
	private static Scanner sc=new Scanner(System.in);
	private ShopUtil() {
		
	}
	public static int readInt(String message) {
		
		while(true) {
			try {
				return Integer.parseInt(readString(message));
			}catch(NumberFormatException e) {
				System.out.println("Please input digit only >>>");
			}
		}
		
	}
	public static String readString(String message) {
		System.out.println(message);
		return sc.nextLine();
	}
}
