package br.com.server.domain.student.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.user.User;
import jakarta.validation.constraints.Size;

public record StudentUpdate(
        String name,
        Instrument instrument,
        ClassFormat classFormat,
        User user
) {
}
