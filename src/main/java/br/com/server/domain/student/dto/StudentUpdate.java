package br.com.server.domain.student.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;

import java.time.DayOfWeek;

public record StudentUpdate(
        String name,
        DayOfWeek daysOfWeek,
        Instrument instrument,
        ClassFormat classFormat
) {
}
