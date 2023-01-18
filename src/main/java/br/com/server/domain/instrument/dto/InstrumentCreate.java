package br.com.server.domain.instrument.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record InstrumentCreate(
		@NotBlank
		String instrument
	) {}
