package org.event.java;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("aggiungi un nuovo evento!\nscrivi il titolo dell'evento: ");
		String title = sc.nextLine();
		
		System.out.println("inserisci una data [GG/MM/AAAA]: ");
		String dateStr = sc.nextLine();
		LocalDate dateObj = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("d/MM/uuuu"));
		
		System.out.println("inserisci il numero di posti disponibili: ");
		int nPostiTotali = Integer.valueOf(sc.nextLine());
		
		
		try {
			Evento e = new Evento(title, dateObj, nPostiTotali);
			System.out.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
}
