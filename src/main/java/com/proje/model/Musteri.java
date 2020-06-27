package com.proje.model;

public class Musteri {
	
	private long musteriId;
	
	private String musteriAdi;
	
	private String musteriSoyadi;
	
	private int yas;
	
	private double maas;
	public Musteri() {

	}

	public Musteri(long musteriId, String musteriAdi, String musteriSoyadi, int yas, double maas) {
		super();
		this.musteriId = musteriId;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
		this.yas = yas;
		this.maas = maas;
	}



	public long getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(long musteriId) {
		this.musteriId = musteriId;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) {
		this.maas = maas;
	}

	@Override
	public String toString() {
		return "Musteri [musteriId=" + musteriId + ", musteriAdi=" + musteriAdi + ", musteriSoyadi=" + musteriSoyadi
				+ ", yas=" + yas + ", maas=" + maas + "]";
	}

	

	
	
	

}
