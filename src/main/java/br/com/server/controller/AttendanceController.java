package br.com.server.controller;

import br.com.server.domain.attendance.dto.AttendanceCreate;
import br.com.server.domain.attendance.dto.AttendanceData;
import br.com.server.domain.attendance.service.AttendanceService;
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
@RequestMapping("/attendances")
@SecurityRequirement(name = "bearer-key")
public class AttendanceController {

  @Autowired
  private AttendanceService attendanceService;

  @PostMapping("/create")
  @Transactional
  public ResponseEntity<AttendanceData> create(@RequestBody @Valid AttendanceCreate data, UriComponentsBuilder uriBuilder) {
    var attendance = attendanceService.create(data);
    var uri = uriBuilder.path("/attendances/{id}").buildAndExpand(attendance.getId()).toUri();
    return ResponseEntity.created(uri).body(new AttendanceData(attendance));
  }

  @GetMapping("/{id}")
  public ResponseEntity<AttendanceData> findById(@PathVariable Long id) {
    var attendance = attendanceService.findById(id);
    return ResponseEntity.ok(new AttendanceData(attendance));
  }

  @GetMapping
  public ResponseEntity<Page<AttendanceData>> findAll(@PageableDefault Pageable pageable,
                                                      @RequestParam(name = "studentId") Long id) {

    var list = attendanceService.findAll(id, pageable);
    return ResponseEntity.ok(list);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatusCode> delete(@PathVariable Long id) {
    attendanceService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
