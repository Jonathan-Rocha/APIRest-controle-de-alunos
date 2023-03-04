package br.com.server.controller;

import br.com.server.domain.format.dto.ClassFormatUpdate;
import br.com.server.domain.user.UserRepository;
import br.com.server.domain.user.dto.UserSearch;
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
	private ClassFormatRepository repository;

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<ClassFormatData> create(@RequestBody @Valid ClassFormatCreate data, UriComponentsBuilder uriBuilder) {
		var user = userRepository.getReferenceById(data.userId());
		var format = new ClassFormat(null, data.modality(), data.timeMinutes(), data.price(), user);
		repository.save(format);
		
		var uri = uriBuilder.path("/formats/{id}").buildAndExpand(format.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ClassFormatData(format));
	}

	@GetMapping("/user")
	public ResponseEntity<Page<ClassFormatData>> findAll(@PageableDefault Pageable pageable, @RequestParam @Valid Long id) {
		var user = userRepository.getReferenceById(id);
		var list = repository.findAllByUserId(pageable, user.getId()).map(ClassFormatData::new);

		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClassFormatData> findById(@PathVariable Long id) {
		var format = repository.getReferenceById(id);

		return ResponseEntity.ok(new ClassFormatData(format));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClassFormatData> update(@PathVariable Long id, @RequestBody @Valid ClassFormatUpdate data) {
		var format = repository.getReferenceById(id);
		format.update(data);

		return ResponseEntity.ok(new ClassFormatData(format));
	}

	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<HttpStatusCode> delete(@PathVariable Long id) {
		var format = repository.getReferenceById(id);
		repository.delete(format);

		return ResponseEntity.noContent().build();
	}
}
