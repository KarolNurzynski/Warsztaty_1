package zad3;

import java.util.Scanner;

public class zad3 {
	
	public static void main(String[] args) {
		
		System.out.println("Pomysl o liczbie z zakresu o do 1000 a ja ja zgadne w max. 10 probach");
		
		int min = 0;
		int max = 1000;
		boolean win = false;
		
		for (int i = 0; i < 10; i++) {
			
			while (win==false) {
				
				int guess = (int)((max-min)/2)+min;
				
				System.out.println("Zgaduje: "+guess);
				
				System.out.println("Wprowadz za duzo/za malo/zgadles: ");
				Scanner scan = new Scanner(System.in);
				String hint = scan.nextLine();
				
				if (hint.equals("zgadles")) {
					System.out.println("Wygralem!");
					win = true;
				}
				else if (hint.equals("za duzo")){
					max = guess;
				} else if (hint.equals("za malo")){
					min = guess;
				} else {
					System.out.println("Nie oszukuj!");
				}
				System.out.println(win);
			}
			
		}
		
	}
	
}
