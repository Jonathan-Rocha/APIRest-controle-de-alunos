package br.com.server.domain.attendance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

  Page<Attendance> findAllByStudentId(Long id, Pageable pageable);
}
