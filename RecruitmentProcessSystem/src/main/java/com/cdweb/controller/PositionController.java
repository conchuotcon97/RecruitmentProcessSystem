package com.cdweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.Position;
import com.cdweb.service.PositionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class PositionController {
	@Autowired
	private PositionService positionService;
	@GetMapping("/titleList")
	public ResponseEntity<List<Position>> getPositionList(){
		List<Position> positions= positionService.getPositionList();
		return ResponseEntity.ok().body(positions);
	
		
	}
	
	
	
	

}
