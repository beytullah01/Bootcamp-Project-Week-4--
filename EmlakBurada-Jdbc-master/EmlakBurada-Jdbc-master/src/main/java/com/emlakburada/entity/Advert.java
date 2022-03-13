package com.emlakburada.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Advert {

	
	public int id;
	public int advertNo;
	public String baslik;

	

	

	public boolean aktifMi;
	
	
	public Advert() {
	}


	public Advert(int id, int advertNo, String baslik) {
		
		this.id = id;
		this.advertNo = advertNo;
		this.baslik = baslik;
	
	}


	@Override
	public String toString() {
		return "Advert [id=" + id + ", advertNo=" + advertNo + ", baslik=" + baslik + " + "+"]";
	}
	
	
	
}
