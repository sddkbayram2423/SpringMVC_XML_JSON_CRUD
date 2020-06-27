package com.proje.controller;

import java.util.List;



import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.proje.model.Musteri;
import com.proje.model.MusteriJSON;
import com.proje.model.MusteriXML;
import com.proje.serviceImpl.MusteriServiceImp;

@RestController
public class DepoTakipController {
	
	@Inject
	private MusteriServiceImp musteriService;

	@RequestMapping("/uretjson/{musteriadi}")
	public MusteriJSON  uretjson(@PathVariable("musteriadi") String musteriadi) {		
		MusteriJSON sonucjson = new MusteriJSON(musteriadi, "JSON "+ musteriadi);
		return sonucjson;
	}
	
	
	@RequestMapping("/uretxml/{musteriadi}")
	public MusteriXML uretxml(@PathVariable("musteriadi") String musteriadi) {		
		MusteriXML sonucxml = new MusteriXML(musteriadi, "XML "+ musteriadi);
		return sonucxml;
	}
	
	@RequestMapping(value = "/musteri",method = RequestMethod.GET)
	public ResponseEntity< List<Musteri> > findAllMusteries(){
		
		List<Musteri> musteris=this.musteriService.findAllMusteris();
				
		if (musteris.isEmpty()) {
			return new ResponseEntity<List<Musteri>>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Musteri>>(musteris,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/musteri/{id}",method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Musteri> getMusteri(@PathVariable("id") long id){
		
		Musteri musteri=this.musteriService.findById(id);
		if (musteri==null) {
			return new ResponseEntity<Musteri>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<Musteri>(musteri,HttpStatus.OK);
	}
	

	@RequestMapping(value = "/musteri/",method = RequestMethod.POST)
	public ResponseEntity< Void > createMusteri(@RequestBody Musteri musteri,UriComponentsBuilder builder){
		
		if (musteriService.isMusteriExist(musteri)) {
			return new ResponseEntity< Void >(HttpStatus.CONFLICT);
		}
		musteriService.saveMusteri(musteri);
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setLocation(builder.path( "/musteri/{id}").buildAndExpand(musteri.getMusteriId()).toUri());
		
		
		return new ResponseEntity< Void >(httpHeaders,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/musteri/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Musteri> updateMusteri(@PathVariable("id") long id,@RequestBody Musteri musteri){
		
		Musteri guncellenenMusteri=this.musteriService.findById(id);
		
		
		if (guncellenenMusteri==null) {
			return new ResponseEntity<Musteri>(HttpStatus.NOT_FOUND);
			
		}
		guncellenenMusteri.setMusteriAdi(musteri.getMusteriAdi());
		guncellenenMusteri.setMusteriSoyadi(musteri.getMusteriSoyadi());
		guncellenenMusteri.setMaas(musteri.getMaas());
		guncellenenMusteri.setYas(musteri.getYas());
		guncellenenMusteri.setMusteriId(musteri.getMusteriId());
		
		musteriService.updateMusteri(guncellenenMusteri);
		
		return new ResponseEntity<Musteri>(guncellenenMusteri,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/musteri/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Musteri> deleteMusteri(@PathVariable("id") long id){
		
		Musteri musteri=this.musteriService.findById(id);
		if (musteri==null) {
			return new ResponseEntity<Musteri>(HttpStatus.NOT_FOUND);
			
		}
		musteriService.deleteMusteriById(id);
		return new ResponseEntity<Musteri>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/musteri/",method = RequestMethod.DELETE)
	public ResponseEntity<Musteri> deleteAllMusteri(){
		musteriService.deleteAllMusteris();
		return new ResponseEntity<Musteri>(HttpStatus.NO_CONTENT);
	}
}
