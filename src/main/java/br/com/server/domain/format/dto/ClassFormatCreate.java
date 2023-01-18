package br.com.server.domain.format.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClassFormatCreate(
		@NotBlank
		String modality,
		
		@NotBlank
		String timeMinutes,
		
		@NotNull
		BigDecimal price
		) {

}
