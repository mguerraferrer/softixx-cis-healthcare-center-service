package mx.softixx.cis.cloud.healthcare.center.exposition.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.exposition.observavility.HealthcareCenterObservation;
import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterDoctorResponse;

@RestController
@RequestMapping("/api/v1/healthcare-centers")
public class HealthcareCenterController {
	
	private final HealthcareCenterObservation healthcareCenterObservation;
	
	public HealthcareCenterController(HealthcareCenterObservation healthcareCenterObservation) {
		this.healthcareCenterObservation = healthcareCenterObservation;
	}

	@GetMapping("/{doctorId}")
	public ResponseEntity<HealthcareCenterDoctorResponse> findByDoctor(@PathVariable Long doctorId) {
		val response = healthcareCenterObservation.findByDoctor(doctorId);
		return ResponseEntity.ok(response);
	}
	
}