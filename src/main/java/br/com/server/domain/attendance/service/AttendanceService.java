package br.com.server.domain.attendance.service;

import br.com.server.domain.attendance.Attendance;
import br.com.server.domain.attendance.AttendanceRepository;
import br.com.server.domain.attendance.dto.AttendanceCreate;
import br.com.server.domain.attendance.dto.AttendanceData;
import br.com.server.domain.student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceService {

  private final AttendanceRepository attendanceRepository;
  private final StudentRepository studentRepository;

  public Attendance create(AttendanceCreate data) {
    return attendanceRepository
            .save(new Attendance(
                    null,
                    data.attendance(),
                    data.absence(),
                    studentRepository.getReferenceById(data.studentId())));
  }

  public Attendance findById(Long id) {
    return attendanceRepository.getReferenceById(id);
  }

  public Page<AttendanceData> findAll(Long id, Pageable pageable) {
    return attendanceRepository
            .findAllByStudentId(id, pageable)
            .map(AttendanceData::new);
  }

  public void delete(Long id) {
    attendanceRepository.deleteById(id);
  }
}
