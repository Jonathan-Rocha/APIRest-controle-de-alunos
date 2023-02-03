package br.com.server.domain.format.dto;

import br.com.server.domain.user.User;

import java.math.BigDecimal;

public record ClassFormatUpdate(
        String modality,
        String timeMinutes,
        BigDecimal price,
        User user
) {
}
