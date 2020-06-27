package com.proje.serviceImpl;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proje.model.Musteri;
import com.proje.service.MusteriService;



@Service
@Transactional
public class MusteriServiceImp implements MusteriService {
	
	private static final AtomicLong sayac=new AtomicLong(); 
	private static List<Musteri> musteries;
	
	static {
		musteries=musteriGetir();
	}
	public static List<Musteri> musteriGetir(){
		List<Musteri> musteries=new ArrayList<Musteri>();
		 musteries.add(new Musteri(sayac.incrementAndGet(), "Onur", "Baran", 27, 3520));
		 musteries.add(new Musteri(sayac.incrementAndGet(), "Meryem", "Atak", 19, 20000));
		 musteries.add(new Musteri(sayac.incrementAndGet(), "Ahmet", "Kaya", 27, 6500));
		 musteries.add(new Musteri(sayac.incrementAndGet(), "Ali", "Tepe", 43, 4856));
		 musteries.add(new Musteri(sayac.incrementAndGet(), "Zahide", "Bayram", 26, 3845));
		
		return musteries;
		}
	
	@Override
	public Musteri findById(long musteriId) {
		for(Musteri musteri:musteries) {
			if(musteri.getMusteriId()==musteriId) {
				return musteri;
			}
		}
		return null;
	}

	@Override
	public Musteri findByName(String musteriAdi) {
		for(Musteri musteri:musteries) {
			if(musteri.getMusteriAdi().equalsIgnoreCase(musteriAdi)) {
				return musteri;
			}
		}
		return null;
		
	}

	@Override
	public void saveMusteri(Musteri musteri) {
		musteri.setMusteriId(sayac.decrementAndGet());
		musteries.add(musteri);
	}

	@Override
	public void updateMusteri(Musteri musteri) {
		int listeKonumu=musteries.indexOf(musteri);
		musteries.set(listeKonumu, musteri);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteMusteriById(long musteriId) {
		for (Iterator iterator = musteries.iterator(); iterator.hasNext();) {
			Musteri musteri = (Musteri) iterator.next();
			if(musteri.getMusteriId()==musteriId) {
				iterator.remove();
			}
			
		}
		
		
	}

	@Override
	public List<Musteri> findAllMusteris() {
		return musteries;
	}

	@Override
	public void deleteAllMusteris() {
		musteries.clear();
	}

	@Override
	public boolean isMusteriExist(Musteri musteri) {
		
		
		return (findByName(musteri.getMusteriAdi())!=null);
	}

}
