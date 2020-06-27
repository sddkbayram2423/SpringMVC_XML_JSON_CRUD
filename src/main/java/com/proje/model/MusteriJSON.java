package com.proje.model;

public class MusteriJSON {
	
	private String adi;
	private String bilgi;
	
	public MusteriJSON() {
	}
	
	public MusteriJSON(String adi, String bilgi) {
		this.adi = adi;
		this.bilgi = bilgi;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getBilgi() {
		return bilgi;
	}

	public void setBilgi(String bilgi) {
		this.bilgi = bilgi;
	}

	@Override
	public String toString() {
		return "MusteriJSON [adi=" + adi + ", bilgi=" + bilgi + "]";
	}
	
	
	
	

}
