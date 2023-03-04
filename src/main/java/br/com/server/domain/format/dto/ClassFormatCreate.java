package br.com.server.domain.format.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClassFormatCreate(
		@NotBlank
		String modality,
		@NotNull
		Integer timeMinutes,
		@NotNull
		Integer price,
		@NotNull
		Long userId
) {
}
