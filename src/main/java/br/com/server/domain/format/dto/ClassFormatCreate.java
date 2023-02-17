package br.com.server.domain.format.dto;

import br.com.server.domain.user.User;
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
		User user
) {
}
