package mx.softixx.cis.cloud.healthcare.center.exposition.observavility;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.exposition.service.HealthcareCenterService;
import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterDoctorResponse;

@Component
public class HealthcareCenterObservation {
	
	private final HealthcareCenterService healthcareCenterService;
	private final ObservationRegistry observationRegistry;

	public HealthcareCenterObservation(HealthcareCenterService healthcareCenterService,
									   ObservationRegistry observationRegistry) {
		this.healthcareCenterService = healthcareCenterService;
		this.observationRegistry = observationRegistry;
	}
	
	public HealthcareCenterDoctorResponse findByDoctor(Long doctorId) {
		val observationName = "HealthcareCenterController#findByDoctor";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("doctorId", String.valueOf(doctorId))
				.observe(() -> healthcareCenterService.findByDoctor(doctorId));
	}
	
}