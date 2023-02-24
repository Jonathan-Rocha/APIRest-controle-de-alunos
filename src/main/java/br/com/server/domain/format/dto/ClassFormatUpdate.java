package br.com.server.domain.format.dto;

public record ClassFormatUpdate(
        String modality,
        Integer timeMinutes,
        Integer price
) {
}
