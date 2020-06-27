package com.proje.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MusteriXML {
	
	private String adi;
	private String bilgi;
	
	public MusteriXML() {
	}

	public MusteriXML(String adi, String bilgi) {
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
		return "MusteriXML [adi=" + adi + ", bilgi=" + bilgi + "]";
	}
	
	

}
