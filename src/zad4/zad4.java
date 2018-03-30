package zad4;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

public class zad4 {
	
	public static void main(String[] args) {
		
		String str1 = "2D10+10";
		String str2 = "D6";
		String str3 = "2D3";
		String str4 = "D12-1";
		
		System.out.println(diceThrow(str1));
		System.out.println(diceThrow(str2));
		System.out.println(diceThrow(str3));
		System.out.println(diceThrow(str4));
			
	}
	
	public static int diceThrow (String str) {
		
		int indD = str.indexOf("D");
		int indPlus = str.indexOf("+");		// if it does not exits, then index = -1
		int indMinus = str.indexOf("-");	// as above
		
		// Finding number of throws
		
		int numberOfThrows = 1;
		
		if (indD!=0) {
			
			numberOfThrows = Integer.parseInt(str.substring(0, indD));
			
		}
		
		// Finding dice dimension
		
		int diceDimension = 0;
		
		if ((indPlus!=-1) || (indMinus!=-1)) {
			
			if (indPlus!=-1) {
				diceDimension = Integer.parseInt(str.substring(indD+1, indPlus));
			} else {
				diceDimension = Integer.parseInt(str.substring(indD+1, indMinus));
			} 
			
		} else {
			diceDimension = Integer.parseInt(str.substring(indD+1));
		}
		
		// Finding modifier
		
		int modifier = 0;
		
		if ((indPlus!=-1) || (indMinus!=-1)) {
			
			if (indPlus!=-1) {
				modifier = Integer.parseInt(str.substring(indPlus+1));
			} else {
				modifier = Integer.parseInt(str.substring(indMinus));
			} 
			
		} else {
			modifier = 0;
		}
		
		// The game
		
		int result = 0;
		
		for (int i = 0; i<numberOfThrows; i++) {
			
			int oneThrow = ThreadLocalRandom.current().nextInt(1,diceDimension+1);
			result+=oneThrow;
		}
		
		return result+modifier;
		
	}
	
}


//W grach planszowych i papierowych RPG używa się wielu rodzajów kostek do gry, nie tylko tych
//dobrze znanych, sześciennych. Jedną z popularniejszych kości jest np. kostka dziesięciościenna, a
//nawet stuścienna!
//Ponieważ w grach kośćmi rzuca się często, pisanie za każdym razem np. "rzuć dwiema kostkami
//dziesięciościennymi, a do wyniku dodaj 20", byłoby żmudne, czasochłonne i marnowałoby ogromne
//ilości papieru.
//W takich sytuacjach używa się kodu skracającego polecenie np.:
//"rzuć 2D10+20".
//
//Kod takiej kostki wygląda następująco:
//xDy+z
//gdzie:
//y – rodzaj kostek, których należy użyć (np. D6, D10),
//x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
//z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.
//Przykłady:
//2D10+10 – 2 rzuty D10, do wyniku dodaj 10,
//D6 – zwykły rzut kostką sześcienną,
//2D3 – rzut dwiema kostkami trójściennymi,
//D12-1 – rzut kością D12, od wyniku odejmij 1.
//
//Napisz funkcję, która:
//1. przyjmie w parametrze taki kod w postaci String,
//2. rozpozna wszystkie dane wejściowe:
//rodzaj kostki,
//liczbę rzutów,
//modyfikator,
//3. wykona symulację rzutów i zwróci wynik.
//Typy kostek występujące w grach:
//D3, D4, D6, D8, D10, D12, D20, D100.

