package com.ultdevchar.mockdatagenerator.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class MockResponseDto {
	
	List<Map<String, Object>> data;
}
