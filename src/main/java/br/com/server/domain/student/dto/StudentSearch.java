package br.com.server.domain.student.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.student.Student;

public record StudentSearch(
        Long id,
        String name,
        Instrument instrument,
        ClassFormat classFormat
) {
    public StudentSearch(Student student){
        this(
                student.getId(),
                student.getName(),
                student.getInstrument(),
                student.getClassFormat()
        );
    }
}
