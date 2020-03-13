package com.hibicode.beerstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;

@Service
public class BeerService {

	@Autowired
	private Beers beersRepository;
	
	public BeerService(@Autowired Beers beers) {
		this.beersRepository = beers;
	}
	
	public Beer save(final Beer beer) {
		Optional<Beer> beerByNameAndType = beersRepository.findByNameAndType(beer.getName(), beer.getType());
		
		if (beerByNameAndType.isPresent()) {
			throw new BeerAlreadyExistException();
		}
		return beersRepository.save(beer);
	}
	
	public ResponseEntity<Void> delete(Long id) {
		Optional<Beer> beerSaved = beersRepository.findById(id);
		
		if (beerSaved.isPresent()) {
    		beersRepository.deleteById(id);
    		return ResponseEntity.noContent().build();
    	} 
		
		return ResponseEntity.notFound().build();
	}
}
