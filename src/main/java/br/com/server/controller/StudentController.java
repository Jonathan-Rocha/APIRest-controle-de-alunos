package br.com.server.controller;

import br.com.server.domain.format.ClassFormatRepository;
import br.com.server.domain.instrument.InstrumentRepository;
import br.com.server.domain.student.Student;
import br.com.server.domain.student.StudentRepository;
import br.com.server.domain.student.dto.StudentCreate;
import br.com.server.domain.student.dto.StudentData;
import br.com.server.domain.student.dto.StudentUpdate;
import br.com.server.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/students")
@SecurityRequirement(name = "bearer-key")
public class StudentController {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private InstrumentRepository instrumentRepository;
    @Autowired
    private ClassFormatRepository classFormatRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/create")
    @Transactional
    public ResponseEntity<StudentData> create(@RequestBody @Valid StudentCreate data, UriComponentsBuilder uriBuilder) {
        var instrument = instrumentRepository.getReferenceById(data.instrumentId());
        var classFormat = classFormatRepository.getReferenceById(data.classFormatId());
        var user = userRepository.getReferenceById(data.userId());
        var student = new Student(null, data.name(), data.daysOfWeek(), instrument, classFormat, user);
        repository.save(student);

        var uri = uriBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).body(new StudentData(student));
    }

    @GetMapping("/user")
    public ResponseEntity<Page<StudentData>> findAll(@PageableDefault Pageable pageable, @RequestParam @Valid Long id) {
        var user = userRepository.getReferenceById(id);
        var list = repository.findAllByUserId(pageable, user.getId()).map(StudentData::new);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentData> findById(@PathVariable Long id) {
        var student = repository.getReferenceById(id);

        return ResponseEntity.ok(new StudentData(student));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StudentData> update(@PathVariable Long id, @RequestBody @Valid StudentUpdate data) {
        var student = repository.getReferenceById(id);

        if (data.name() != null) {
            student.setName(data.name());
        }
        if (data.daysOfWeek() != null) {
            student.setDaysOfWeek(data.daysOfWeek());
        }
        if (data.instrumentId() != null) {
            var instrument = instrumentRepository.getReferenceById(data.instrumentId());
            student.setInstrument(instrument);
        }
        if (data.classFormatId() != null) {
            var format = classFormatRepository.getReferenceById(data.classFormatId());
            student.setClassFormat(format);
        }

        return ResponseEntity.ok(new StudentData(student));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<HttpStatusCode> delete(@PathVariable Long id) {
        var student = repository.getReferenceById(id);
        repository.delete(student);

        return ResponseEntity.noContent().build();
    }
}
