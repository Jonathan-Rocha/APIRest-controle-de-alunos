package br.com.server.domain.student.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;

public record StudentUpdate(
        String name,
        Instrument instrument,
        ClassFormat classFormat
) {
}
