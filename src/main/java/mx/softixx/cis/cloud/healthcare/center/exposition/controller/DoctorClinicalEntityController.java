package mx.softixx.cis.cloud.healthcare.center.exposition.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.exposition.observavility.DoctorClinicalEntityObservation;
import mx.softixx.cis.common.healthcare.center.payload.DoctorClinicalEntityResponse;

@RestController
@RequestMapping("/api/v1/doctor-clinical-entities")
public class DoctorClinicalEntityController {
	
	private final DoctorClinicalEntityObservation doctorClinicalEntityObservation;

	public DoctorClinicalEntityController(DoctorClinicalEntityObservation doctorClinicalEntityObservation) {
		this.doctorClinicalEntityObservation = doctorClinicalEntityObservation;
	}
	
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<List<DoctorClinicalEntityResponse>> findByDoctor(@PathVariable Long doctorId) {
		val response = doctorClinicalEntityObservation.findByDoctor(doctorId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/doctor/{doctorId}/clinical-entity/{clinicalentityId}")
	public ResponseEntity<DoctorClinicalEntityResponse> findByDoctorAndClinicalEntity(@PathVariable Long doctorId,
																					  @PathVariable Long clinicalEntityId) {
		val response = doctorClinicalEntityObservation.findByDoctorAndClinicalEntity(doctorId, clinicalEntityId);
		return ResponseEntity.ok(response);
	}
	
}