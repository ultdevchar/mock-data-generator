package com.ultdevchar.mockdatagenerator.serviceImpl;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.ultdevchar.mockdatagenerator.dto.MockDto;
import com.ultdevchar.mockdatagenerator.dto.MockItemDto;
import com.ultdevchar.mockdatagenerator.dto.MockResponseDto;
import com.ultdevchar.mockdatagenerator.enums.MockDataType;
import com.ultdevchar.mockdatagenerator.service.MockDataService;

@Service
public class MockDataServiceImpl implements MockDataService {
	
	private final String NUMBER_PRECISION = "%.2f";
	private final int NUMBER_MAX_VALUE = 1000;
	private final int TEXT_LENGTH = 20;
	private final int DATA_COUNT_MAX_VALUE = 1000;
	
	private Date initialDate;

	@Override
	public MockResponseDto generateMockData(MockDto mockDto) {
		
		MockResponseDto mockResponseDto = new MockResponseDto();
		
		List<Map<String, Object>> mockDataList = new ArrayList<>();
		
		int dataCount = mockDto.getDataCount();
		
		if(dataCount > DATA_COUNT_MAX_VALUE) {
			dataCount = DATA_COUNT_MAX_VALUE;
		}
		
		for(int i = 0; i < dataCount; i++) {
			
			Map<String, Object> singleItemMap = new HashMap<String, Object>();
			
			for (MockItemDto item: mockDto.getItems()){
				
				singleItemMap.put(item.getKey(), generateSingleData(i, item.getType()));
			}
			
			mockDataList.add(singleItemMap);
		}
		
		mockResponseDto.setData(mockDataList);
		
		return mockResponseDto;
	}
	
	private Object generateSingleData(int index, MockDataType type){
		
		Object value = null;
		
		switch(type) {
			case id:
				value = UUID.randomUUID();
				break;
			case number:
				value = Double.parseDouble(String.format(NUMBER_PRECISION, Math.random() * NUMBER_MAX_VALUE + 1));
				break;
			case text:
				value = RandomStringUtils.randomAlphabetic(TEXT_LENGTH);
				break;
			case date:
				
				if(index == 0) {
					value = new Date(ThreadLocalRandom.current().nextInt() * 1000L);
					initialDate = (Date) value;
				}
				else {
					value = Date.from(initialDate.toInstant().plus(index, ChronoUnit.DAYS));
				}
				
				break;
		}
		
		return value;
	}
}
