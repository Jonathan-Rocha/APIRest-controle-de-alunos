package br.com.server.domain.student.service;

import br.com.server.domain.format.ClassFormatRepository;
import br.com.server.domain.instrument.InstrumentRepository;
import br.com.server.domain.student.Student;
import br.com.server.domain.student.StudentRepository;
import br.com.server.domain.student.dto.StudentCreate;
import br.com.server.domain.student.dto.StudentData;
import br.com.server.domain.student.dto.StudentUpdate;
import br.com.server.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final InstrumentRepository instrumentRepository;
  private final ClassFormatRepository classFormatRepository;
  private final UserRepository userRepository;

  public Student create(StudentCreate data) {
    return studentRepository.save(new Student(null, data.name(), data.daysOfWeek(),
            instrumentRepository.getReferenceById(data.instrumentId()),
            classFormatRepository.getReferenceById(data.classFormatId()),
            userRepository.getReferenceById(data.userId())
    ));
  }

  public Page<StudentData> findAll(Long id, Pageable pageable) {
    return studentRepository.findAllByUserId(pageable,
            userRepository.getReferenceById(id).getId())
            .map(StudentData::new);
  }

  public Student findById(Long id) {
    return studentRepository.getReferenceById(id);
  }

  public Student update(Long id, StudentUpdate data) {
    var student = studentRepository.getReferenceById(id);
    if (data.name() != null) {
      student.setName(data.name());
    }
    if (data.daysOfWeek() != null) {
      student.setDaysOfWeek(data.daysOfWeek());
    }
    if (data.instrumentId() != null) {
      student.setInstrument(instrumentRepository.getReferenceById(data.instrumentId()));
    }
    if (data.classFormatId() != null) {
      student.setClassFormat(classFormatRepository.getReferenceById(data.classFormatId()));
    }
    return student;
  }

  public void delete(Long id) {
    studentRepository.delete(studentRepository.getReferenceById(id));
  }
}
