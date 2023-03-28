package br.com.server.domain.attendance.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AttendanceCreate(
        @NotNull
        Boolean attendance,
        @NotNull
        LocalDate absence,
        @NotNull
        Long studentId
) {
}
