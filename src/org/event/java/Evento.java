package org.event.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String title;
	private LocalDate time;  
	private int nPostiTotali;
	private int nPostiPrenotati = 0;
	
	public Evento(String title, LocalDate time, int nPostiTotali) throws Exception {
		setTitle(title);
		setTime(time);
		setnPostiTotali(nPostiTotali);
		setnPostiPrenotati(nPostiTotali);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) throws Exception {
		if(this.time.now().isAfter(time))
			throw new Exception("la data è già passata");
		
		this.time = time;
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

	private void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}
	
	 public void prenota(LocalDate data) throws Exception {
		 if(this.time.now().isAfter(data) || (nPostiTotali - nPostiPrenotati) < 0)
			 throw new Exception("i posti o la data sono sbagliati");
		 
		 nPostiTotali += 1;
	 }
	 
	 public void disdici(LocalDate data) throws Exception { 
		 if(this.time.now().isAfter(data) || nPostiPrenotati < 0)
			 throw new Exception("i posti o la data sono sbagliati");
		 
		 nPostiTotali -= 1;
	 }
	 
	 @Override
	public String toString() {
		 
		return  time.format(DateTimeFormatter.ofPattern("d/MM/uuuu")) + " - " + title;
	}
	 
	
}
