package br.com.server.domain.student.dto;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.instrument.Instrument;
import br.com.server.domain.student.Student;
import br.com.server.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.DayOfWeek;

public record StudentData(
        Long id,
        String name,
        DayOfWeek daysOfWeek,
        @JsonIgnoreProperties(value = "hibernateLazyInitializer")
        Instrument instrument,
        @JsonIgnoreProperties(value = "hibernateLazyInitializer")
        ClassFormat classFormat,
        @JsonIgnoreProperties(value = {"enabled", "username", "authorities", "accountNonExpired", "credentialsNonExpired", "accountNonLocked", "hibernateLazyInitializer"})
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
