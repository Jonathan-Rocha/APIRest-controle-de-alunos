package br.com.server.domain.format.dto;

import br.com.server.domain.format.ClassFormat;

import java.math.BigDecimal;

public record ClassFormatSerch(
        Long id,
        String modality,
        String timeMinutes,
        BigDecimal price
) {
    public ClassFormatSerch(ClassFormat classFormat) {
        this(
                classFormat.getId(),
                classFormat.getModality(),
                classFormat.getTimeMinutes(),
                classFormat.getPrice()
        );
    }
}
