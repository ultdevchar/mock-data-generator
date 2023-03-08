package com.ultdevchar.mockdatagenerator.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MockDto {
	
	@Positive
	private int dataCount;
	
	@NotEmpty
	private List<@Valid MockItemDto> items;
}
