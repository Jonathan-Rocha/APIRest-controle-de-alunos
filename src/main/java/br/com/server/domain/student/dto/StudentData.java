package br.com.server.domain.student.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.student.Student;
import br.com.server.domain.user.User;

import java.time.DayOfWeek;

public record StudentData(
        Long id,
        String name,
        DayOfWeek daysOfWeek,
        Instrument instrument,
        ClassFormat classFormat,
        User user
) {
    public StudentData(Student student) {
        this(
                student.getId(),
                student.getName(),
                student.getDaysOfWeek(),
                student.getInstrument(),
                student.getClassFormat(),
                student.getUser()
        );
    }
}
