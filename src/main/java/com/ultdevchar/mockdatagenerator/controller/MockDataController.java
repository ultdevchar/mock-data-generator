package com.ultdevchar.mockdatagenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultdevchar.mockdatagenerator.dto.MockDto;
import com.ultdevchar.mockdatagenerator.dto.MockResponseDto;
import com.ultdevchar.mockdatagenerator.service.MockDataService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MockDataController {
	
	private MockDataService mockDataService;
	
	public MockDataController(MockDataService mockDataService) {
		this.mockDataService = mockDataService;
	}
	
	@PostMapping("/generate")
	public ResponseEntity<MockResponseDto> test(@Valid @RequestBody MockDto mockDto){
		return ResponseEntity.ok(mockDataService.generateMockData(mockDto));
	}

}
