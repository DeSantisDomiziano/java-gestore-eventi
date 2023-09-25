package org.event.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento{
	
	LocalTime timeNow;
	BigDecimal price;
	
	public Concerto(String title, LocalDate time, int nPostiTotali) throws Exception {
		super(title, time, nPostiTotali);
		setPrice(price);
		setTimeNow(timeNow);
		
	}

	public LocalTime getTimeNow() {
		return timeNow;
	}

	public void setTimeNow(LocalTime timeNow) {
		this.timeNow = timeNow;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
