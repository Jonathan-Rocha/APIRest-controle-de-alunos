package br.com.server.domain.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;

public record StudentCreate(
        @NotBlank
        String name,
        @NotNull
        DayOfWeek daysOfWeek,
        @NotNull
        Long instrumentId,
        @NotNull
        Long classFormatId,
        @NotNull
        Long userId
) {
}
