package br.com.server.domain.attendance.dto;

import br.com.server.domain.attendance.Attendance;
import br.com.server.domain.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

public record AttendanceData(
        Long id,
        Boolean attendance,
        LocalDate absence,
        @JsonIgnoreProperties(value = "hibernateLazyInitializer")
        Student student
) {
  public AttendanceData(Attendance attendance) {
    this(
            attendance.getId(),
            attendance.getAttendance(),
            attendance.getAbsence(),
            attendance.getStudent()
    );
  }
}
