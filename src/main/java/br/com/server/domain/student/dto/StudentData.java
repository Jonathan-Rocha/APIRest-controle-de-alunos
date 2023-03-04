package br.com.server.domain.student.dto;

import br.com.server.domain.student.Student;

import java.time.DayOfWeek;

public record StudentData(
        Long id,
        String name,
        DayOfWeek daysOfWeek,
        Long instrumentId,
        Long classFormatId,
        Long userId
) {
    public StudentData(Student student) {
        this(
                student.getId(),
                student.getName(),
                student.getDaysOfWeek(),
                student.getInstrument().getId(),
                student.getClassFormat().getId(),
                student.getUser().getId()
        );
    }
}
