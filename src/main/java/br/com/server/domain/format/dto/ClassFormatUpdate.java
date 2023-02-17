package br.com.server.domain.format.dto;

import br.com.server.domain.user.User;

public record ClassFormatUpdate(
        String modality,
        Integer timeMinutes,
        Integer price,
        User user
) {
}
