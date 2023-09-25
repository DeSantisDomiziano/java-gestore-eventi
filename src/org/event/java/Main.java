package org.event.java;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		//--------M3 Start -----------
		LocalDate dateprova = LocalDate.now();
		LocalTime timeprova = LocalTime.parse("19:30:30");
		BigDecimal bd = new BigDecimal("10.001230").setScale(2, RoundingMode.HALF_UP);
		try {
			Concerto concerto = new Concerto("ciaoooo", dateprova, 10, timeprova, bd);
			System.out.println(concerto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-------M3 End------------
		
		Evento event = null;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("aggiungi un nuovo evento!\nscrivi il titolo dell'evento: ");
		String title = sc.nextLine();
		
		System.out.println("inserisci una data [GG/MM/AAAA]: ");
		LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d/MM/uuuu"));
		
		System.out.println("inserisci il numero di posti disponibili: ");
		int nPostiTotali = Integer.valueOf(sc.nextLine());
		
		
		try {
			event = new Evento(title, date, nPostiTotali);
			System.out.println(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Quanti posti vuoi prenotare?: ");
		int nPostiPrenotati = Integer.valueOf(sc.nextLine());
		
		for(int i = 0; i < nPostiPrenotati; i++) {
			try {
				event.prenota(date, nPostiPrenotati);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Prenotati | Totali \n   " + event.getnPostiPrenotati() + "      |   " + event.getnPostiTotali());
		
		System.out.println("\n###########################################\n");
		
		System.out.println("vuoi disdire qualche posto? [si/no]: ");
		
		String disdetta = sc.nextLine();
		if(disdetta.equalsIgnoreCase("si")) {
			
			System.out.println("quanti posti vuoi disdire?: ");
			int nPostiDisdetta = Integer.valueOf(sc.nextLine());
			
			for(int i = 0; i < nPostiDisdetta; i++) {
				try {
					event.disdici(date);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Prenotati | Totali \n   " + event.getnPostiPrenotati() + "      |   " + event.getnPostiTotali());
	}
}
