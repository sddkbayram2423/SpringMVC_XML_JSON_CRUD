package com.proje.service;

import java.util.List;

import com.proje.model.Musteri;



public interface MusteriService {
	
	Musteri findById(long musteriId);
	
	Musteri findByName(String musteriAdi);
	
	void saveMusteri(Musteri musteri);
	
	void updateMusteri(Musteri musteri);
	
	void deleteMusteriById(long musteriId);
	
	List<Musteri> findAllMusteris();
	
	void deleteAllMusteris();
	
	boolean isMusteriExist(Musteri musteri);

}
