package br.com.server.domain.instrument.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public record InstrumentUpdate(
        String instrument
) {
}
