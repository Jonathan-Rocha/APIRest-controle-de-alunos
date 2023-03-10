package br.com.server.controller;

import br.com.server.domain.format.dto.ClassFormatUpdate;
import br.com.server.domain.format.service.ClassFormatService;
import br.com.server.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.server.domain.format.ClassFormat;
import br.com.server.domain.format.ClassFormatRepository;
import br.com.server.domain.format.dto.ClassFormatCreate;
import br.com.server.domain.format.dto.ClassFormatData;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/formats")
@SecurityRequirement(name = "bearer-key")
public class ClassFormatController {
	@Autowired
	private ClassFormatService classFormatService;
	
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<ClassFormatData> create(@RequestBody @Valid ClassFormatCreate data, UriComponentsBuilder uriBuilder) {
		var format = classFormatService.create(data);
		var uri = uriBuilder.path("/formats/{id}").buildAndExpand(format.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClassFormatData(format));
	}

	@GetMapping("/user")
	public ResponseEntity<Page<ClassFormatData>> findAll(@PageableDefault Pageable pageable, @RequestParam @Valid Long id) {
		var list = classFormatService.findAll(id, pageable);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClassFormatData> findById(@PathVariable Long id) {
		var format = classFormatService.findById(id);
		return ResponseEntity.ok(new ClassFormatData(format));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClassFormatData> update(@PathVariable Long id, @RequestBody @Valid ClassFormatUpdate data) {
		var format = classFormatService.update(id, data);
		return ResponseEntity.ok(new ClassFormatData(format));
	}

	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<HttpStatusCode> delete(@PathVariable Long id) {
		classFormatService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
