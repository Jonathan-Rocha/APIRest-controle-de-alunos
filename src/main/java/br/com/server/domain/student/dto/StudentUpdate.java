package br.com.server.domain.student.dto;

import java.time.DayOfWeek;

public record StudentUpdate(
        String name,
        DayOfWeek daysOfWeek,
        Long instrumentId,
        Long classFormatId
) {
}
