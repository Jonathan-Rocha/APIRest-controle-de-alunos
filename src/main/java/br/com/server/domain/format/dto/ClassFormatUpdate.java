package br.com.server.domain.format.dto;

import java.math.BigDecimal;

public record ClassFormatUpdate(
        String modality,
        String timeMinutes,
        BigDecimal price
) {
}
