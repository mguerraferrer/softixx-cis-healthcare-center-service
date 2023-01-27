package mx.softixx.cis.cloud.healthcare.center.exposition.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.exposition.observavility.PrivatePracticeObservation;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeRequest;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeResponse;

@RestController
@RequestMapping("/api/v1/private-practices")
public class PrivatePracticeController {
	
	private final PrivatePracticeObservation privatePracticeObservation;
	
	public PrivatePracticeController(PrivatePracticeObservation privatePracticeObservation) {
		this.privatePracticeObservation = privatePracticeObservation;
	}

	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<PrivatePracticeResponse> findByDoctorId(@PathVariable Long doctorId) {
		val response = privatePracticeObservation.findByDoctor(doctorId);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<PrivatePracticeResponse> create(@RequestBody @Valid PrivatePracticeRequest request) {
		val response = privatePracticeObservation.create(request);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PrivatePracticeResponse> update(@PathVariable Long id, @RequestBody PrivatePracticeRequest request) {
		val response = privatePracticeObservation.update(id, request);
		return ResponseEntity.ok(response);
	}
	
}