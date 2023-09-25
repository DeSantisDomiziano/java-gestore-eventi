package org.event.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Concerto extends Evento{
	
	private LocalTime time;
	private BigDecimal price;
	
	public Concerto(String title, LocalDate date, int nPostiTotali,
					LocalTime time ,BigDecimal price ) throws Exception {
		
		super(title, date, nPostiTotali);
		setPrice(price);
		setTime(time);
		
	}

	public LocalTime getTimeNow() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getFormatTime(String time) {
		LocalTime t = this.time.parse(time);
		String s = t.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT));
        return s;
	}
	
	@Override
	public String toString() {
		
		return  "Data: " + getDate() + "\n" +
				"Orario: " + getFormatTime(time.toString()) + "\nNome Evento: " + 
				getTitle() + "\nPrezzo: " + getPrice() + "€";
	}
}
