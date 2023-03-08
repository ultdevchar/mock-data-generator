package com.ultdevchar.mockdatagenerator.service;

import com.ultdevchar.mockdatagenerator.dto.MockDto;
import com.ultdevchar.mockdatagenerator.dto.MockResponseDto;

public interface MockDataService {
	
	MockResponseDto generateMockData(MockDto mockDto);
}
