package org.event.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String title;
	private LocalDate date;  
	private int nPostiTotali;
	private int nPostiPrenotati = 0;
	
	public Evento(String title, LocalDate date, int nPostiTotali) throws Exception {
		setTitle(title);
		setDate(date);
		setnPostiTotali(nPostiTotali);

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate time) throws Exception {
		if(this.date.now().isAfter(time))
			throw new Exception("la data è già passata");
		
		this.date = time;
	}

	public int getnPostiTotali() {
		return nPostiTotali;
	}

	private void setnPostiTotali(int nPostiTotali) throws Exception {
		if(nPostiTotali < 0)
			throw new Exception("i posti non possono essere meno di 0");
		
		this.nPostiTotali = nPostiTotali;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	
	 public void prenota(LocalDate date, int n) throws Exception {
		 
		 if(this.date.now().isAfter(date) ||nPostiTotali - nPostiPrenotati < 0)
			 throw new Exception("i posti o la data sono sbagliati");
		 
		 nPostiPrenotati += nPostiTotali - nPostiPrenotati > 0 ? 1 : 0;
	 }
	 
	 public void disdici(LocalDate date) throws Exception { 
		 if(this.date.now().isAfter(date) || nPostiPrenotati < 0)
			 throw new Exception("i posti o la data sono sbagliati");
		 
		 nPostiPrenotati -= nPostiTotali - nPostiPrenotati > 0 ? 1 : 0;
	 }
	 
	 @Override
	public String toString() {
		return  date.format(DateTimeFormatter.ofPattern("d/MM/uuuu")) + " - " + title;
	}
	 
	
}
