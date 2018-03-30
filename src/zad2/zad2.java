package zad2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

public class zad2 {
	
	public static void main(String[] args) {
		
		// Lotto draws 6 numbers and returns a sorted table with the draw
		
		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		Collections.shuffle(Arrays.asList(arr));
		
		Integer[] lottoArr = Arrays.copyOf(arr, 6);
		Arrays.sort(lottoArr);
		System.out.println("Lotto draw: "+Arrays.toString(lottoArr));
		
		// User types numbers
		
		int[] userArr = new int[6];
		
		Scanner scan = new Scanner(System.in);
		
		for (int i =0; i < 6; i++) {
		
			System.out.println("Enter number: ");
			int number =Integer.parseInt(scan.next());
			
			while(ArrayUtils.contains(userArr, number)) {
				System.out.println("Number already chosen. Enter other number: ");
				number =Integer.parseInt(scan.next());
			}
			
			userArr[i] = number;

		}
		
		Arrays.sort(userArr);
		
		System.out.println("User numbers: "+Arrays.toString(userArr));
		
		// Here I compare user inputs with lotto draw
		
		int counter = 0;

		for (int number : userArr) {
			if (Arrays.asList(lottoArr).contains(number)) {
				counter++;
			}
		}
		
		if (counter >= 3) {
			System.out.println("You win! (3 or more numbers eqals lotto draw)");
		}
	}
}


//Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu 
//od 1 do 49.
//Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest 
//trafienie 3, 4, 5 lub 6
//poprawnych liczb.
//Napisz program, który:
//zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
//czy wprowadzony ciąg znaków jest poprawną liczbą,
//czy użytkownik nie wpisał tej liczby już poprzednio,
//czy liczba należy do zakresu 1-49,
//po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
//wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
//poinformuje gracza, czy trafił przynajmniej "trójkę".
//
//Aby wylosować 6 liczb z zakresu 1-49 bez powtórzeń możemy utworzyć tablicę 
//z wartościami z tego
//zakresu, wymieszać jej zawartość i pobrać pierwsze 6 elementów.
//Poniższy kod powinien Ci pomóc:
//Integer[] arr = new Integer[49];
//for (int i = 0; i < arr.length; i++) {
//arr[i] = i + 1;
//}
//System.out.println(Arrays.toString(arr));
//Collections.shuffle(Arrays.asList(arr));
//System.out.println(Arrays.toString(arr));
//Możesz również losować liczby z określonego zakresu przy użyciu klasy Random 
//(sprawdź w
//snippetach jak to wykonać) – jeżeli wybierzesz takie rozwiązanie, pamiętaj 
//o sprawdzaniu czy dana
//wartość nie została wcześniej wylosowana.




//Scanner scan = new Scanner(System.in);
//
//int number = 0;
//
//System.out.println("Enter number: ");
//int number =Integer.parseInt(scan.next());
//if ((number>=1) && (number<=49)) {
//	
//	number=number;
//	
//}
//else {
//	
//	
//	
//}
//
//for (int i =0;i < 6;i++) {
//	
//	System.out.println("Enter number: ");
//	int number =Integer.parseInt(scan.next());
//
//	if (newNumber != number) {
//		
//		number = newNumber;
//		
//	}
//	else {
//		
//		System.out.println("This number already was introduced.");
//		
//	}
//	
//	
//	
//}