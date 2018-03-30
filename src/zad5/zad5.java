package zad5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class zad5 {
	
	public static void main(String[] args) {
		
		Connection connect = Jsoup.connect("http://www.wp.pl/");
		Connection connect2 = Jsoup.connect("http://www.gazeta.pl/");
		Connection connect3 = Jsoup.connect("http://www.tvn24.pl/");
		
		String strPath = "popular_words.txt";
		String strPath2 = "filtered_popular_words.txt";
		Path path = Paths.get(strPath);
		Path path2 = Paths.get(strPath2);
		
		
		try {
			
			FileWriter fw = new FileWriter(strPath);
			
			Document document = connect.get();
			Document document2 = connect.get();
			Document document3 = connect.get();
			
			Elements links = document.select("a[title]");
			Elements links2 = document2.select("a[title]");
			Elements links3 = document3.select("a[title]");
			Elements[] elemArr = {links, links2, links3};
			
			for (Elements elements : elemArr) {
				
				for (Element elem : links3) {
					
					String str = elem.text();
					
					StringTokenizer st = new StringTokenizer(str,",.\n \"");
					
					while(st.hasMoreTokens()) {
						
						String s = st.nextToken().toLowerCase();
						
						if (s.length() > 3) {
							
							fw.append(s+"\n");
						}
					}
				}
				
			}
			
			fw.close();	
			
			String[] arr = {"oraz", "ponieważ", "albowiem"};
			
			Scanner scan = new Scanner(path);
			FileWriter fw2 = new FileWriter(strPath2);
			
			while (scan.hasNextLine()) {
				
				String str = scan.nextLine();
				
				if (!Arrays.asList(arr).contains(str)) {
					
					fw2.append(str+"\n");
					
				}
				
			}
			
			fw2.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}


//Zaimportuj do projektu bibliotekę jsoup, możesz ją pobrać z adresu: 
//	https://jsoup.org/download
//Wyszukaj w popularnych serwisach internetowych nagłówków artykułów, 
//a następnie zapisz
//pojedyncze słowa w nich występujące do pliku o nazwie popular_words.txt. 
//Przykład
//pobrania tytułów z tagu html span z atrybutem class o wartości title:
//Connection connect = Jsoup.connect("http://www.onet.pl/");
//try {
//Document document = connect.get();
//Elements links = document.select("span.title");
//for (Element elem : links) {
//System.out.println(elem.text());
//}
//} catch (IOException e) {
//		e.printStackTrace();
//}
//Wywołaj pobieranie dla wybranych serwisów internetowych.
//Pomiń wszystkie elementy krótsze niż 3-znakowe.
//Utwórz tablicę elementów wykluczonych np. oraz, ponieważ
//Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik
//filtered_popular_words.txt, który zawierać będzie wszystkie znalezione słowa, 
//pomijając słowa wykluczone.

