package com.maheshb.springbootkafkaintro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {

	private Long timestamp;
	private Double value;
	private String tagName;

	

}
