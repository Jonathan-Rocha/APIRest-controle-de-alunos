package br.com.server.domain.attendance;

import br.com.server.domain.student.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "attendances")
@Entity(name = "Attendances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Boolean attendance;
  private LocalDate absence;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id")
  private Student student;
}
