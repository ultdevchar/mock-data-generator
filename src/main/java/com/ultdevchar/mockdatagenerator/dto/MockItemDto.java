package com.ultdevchar.mockdatagenerator.dto;

import com.ultdevchar.mockdatagenerator.enums.MockDataType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MockItemDto {
	
	@NotBlank
	private String key;
	
	@NotNull
	private MockDataType type;
}
