package br.com.server.controller;

import br.com.server.domain.student.Student;
import br.com.server.domain.student.StudentRepository;
import br.com.server.domain.student.dto.StudentCreate;
import br.com.server.domain.student.dto.StudentData;
import br.com.server.domain.student.dto.StudentUpdate;
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

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<StudentData> create(@RequestBody @Valid StudentCreate data, UriComponentsBuilder uriBuilder) {
        var student = new Student(data);
        repository.save(student);

        var uri = uriBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(uri).body(new StudentData(student));
    }

    @GetMapping("/user")
    public ResponseEntity<Page<StudentData>> findAll(@PageableDefault Pageable pageable, @RequestParam @Valid Long id) {
        var user = repository.getReferenceById(id);
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
        student.update(data);

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
