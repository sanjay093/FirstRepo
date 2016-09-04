package com.mar2.fps.controller;

import org.springframework.http.MediaType;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mar2.fps.DAO.FPPortalDAO;
import com.mar2.fps.DTO.FPPortalDTO;

@RestController
@EnableAutoConfiguration
public class FPPortalController {
	
	@Autowired
	private FPPortalDAO fPPortalDAO;
	
	@RequestMapping(value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<FPPortalDTO>> getALL(){
		System.out.println("getALL");
		Collection<FPPortalDTO> data = fPPortalDAO.getMap().values();
		if(data == null || data.isEmpty()){
			return new ResponseEntity<Collection<FPPortalDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<FPPortalDTO>>(data, HttpStatus.FOUND);
	}
	
	
	@RequestMapping(value = "/save", 
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FPPortalDTO> saveData(@RequestBody FPPortalDTO fpdto){
		System.out.println("saveData");
		Map<Integer, FPPortalDTO> map = fPPortalDAO.getMap();
		if(fpdto != null){
			map.put(fpdto.getId(), fpdto);
			return new ResponseEntity<FPPortalDTO>(fpdto, HttpStatus.OK);
		}
		return new ResponseEntity<FPPortalDTO>(fpdto, HttpStatus.BAD_REQUEST);
		
	}
}
