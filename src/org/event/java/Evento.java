package org.event.java;

import java.time.LocalTime;

public class Evento {
	private String title;
	private LocalTime time;  
	private int nPostiTotali;
	private int nPostiPrenotati = 0;
	
	public Evento(String title, LocalTime time, int nPostiTotali) throws Exception {
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) throws Exception {
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
	
	 
	
}
