package br.com.server.controller;

import br.com.server.domain.instrument.dto.InstrumentUpdate;
import br.com.server.domain.instrument.service.InstrumentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.server.domain.instrument.dto.InstrumentCreate;
import br.com.server.domain.instrument.dto.InstrumentData;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/instruments")
@SecurityRequirement(name = "bearer-key")
public class InstrumentController {

	@Autowired
	private InstrumentService instrumentService;
	
	@PostMapping("/create")
	@Transactional
	public ResponseEntity<InstrumentData> create(@RequestBody @Valid InstrumentCreate data, UriComponentsBuilder uriBuilder){
		var instrument = instrumentService.create(data);
		var uri = uriBuilder.path("/instruments/{id}").buildAndExpand(instrument.getId()).toUri();
		return ResponseEntity.created(uri).body(new InstrumentData(instrument));
	}

	@GetMapping
	public ResponseEntity<Page<InstrumentData>> findAll(@PageableDefault Pageable pageable) {
		var list = instrumentService.findAll(pageable);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<InstrumentData> findById(@PathVariable Long id) {
		var instrument = instrumentService.findById(id);
		return ResponseEntity.ok(new InstrumentData(instrument));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<InstrumentData> update(@PathVariable Long id, @RequestBody @Valid InstrumentUpdate data) {
		var instrument = instrumentService.update(id, data);
		return ResponseEntity.ok(new InstrumentData(instrument));
	}
}
