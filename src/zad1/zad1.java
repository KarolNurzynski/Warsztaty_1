package zad1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class zad1 {
	
	public static void main(String[] args) {
		
		int rand = ThreadLocalRandom.current().nextInt(0,101);
		
		System.out.println("Zgadnij liczbe: ");
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			try {
				int num = Integer.parseInt(scan.next());
				
				if (num>rand) {
					System.out.println("Za duzo!");
				} else if (num<rand) {
					System.out.println("Za malo!");
				} else {
					System.out.println("Zgadles!");
					break;
				}
				
			} catch (Exception e) {
				System.out.println("To nie jest liczba");
			}
		
		}
		
		scan.close();
		System.out.println("Koniec");

	}
	
}