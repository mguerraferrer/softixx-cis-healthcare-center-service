package mx.softixx.cis.cloud.healthcare.center.exposition.observavility;

import java.util.List;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.exposition.service.DoctorClinicalEntityService;
import mx.softixx.cis.common.healthcare.center.payload.DoctorClinicalEntityResponse;

@Component
public class DoctorClinicalEntityObservation {
	
	private final DoctorClinicalEntityService doctorClinicalEntityService;
	private final ObservationRegistry observationRegistry;

	public DoctorClinicalEntityObservation(DoctorClinicalEntityService doctorClinicalEntityService,
									  	   ObservationRegistry observationRegistry) {
		this.doctorClinicalEntityService = doctorClinicalEntityService;
		this.observationRegistry = observationRegistry;
	}
	
	public List<DoctorClinicalEntityResponse> findByDoctor(Long doctorId) {
		val observationName = "DoctorClinicalEntityController#findByDoctor";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("doctorId", String.valueOf(doctorId))
				.observe(() -> doctorClinicalEntityService.findByDoctor(doctorId));
	}
	
	public DoctorClinicalEntityResponse findByDoctorAndClinicalEntity(Long doctorId, Long clinicalEntityId) {
		val observationName = "DoctorClinicalEntityController#findByDoctorAndClinicalEntity";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("doctorId", String.valueOf(doctorId))
				.lowCardinalityKeyValue("clinicalEntityId", String.valueOf(clinicalEntityId))
				.observe(() -> doctorClinicalEntityService.findByDoctorAndClinicalEntity(doctorId, clinicalEntityId));
	}
	
}