package mx.softixx.cis.cloud.healthcare.center.exposition.observavility;

import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.exposition.service.PrivatePracticeService;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeRequest;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeResponse;

@Component
public class PrivatePracticeObservation {
	
	private final PrivatePracticeService privatePracticeService;
	private final ObservationRegistry observationRegistry;

	public PrivatePracticeObservation(PrivatePracticeService privatePracticeService,
									  ObservationRegistry observationRegistry) {
		this.privatePracticeService = privatePracticeService;
		this.observationRegistry = observationRegistry;
	}
	
	public PrivatePracticeResponse findByDoctor(Long doctorId) {
		val observationName = "PrivatePracticeController#findByDoctor";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("doctorId", String.valueOf(doctorId))
				.observe(() -> privatePracticeService.findByDoctor(doctorId));
	}
	
	public PrivatePracticeResponse create(PrivatePracticeRequest request) {
		val observationName = "PrivatePracticeController#create";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("doctorId", String.valueOf(request.getDoctorId()))
				.observe(() -> privatePracticeService.create(request));
	}
	
	public PrivatePracticeResponse update(Long id, PrivatePracticeRequest request) {
		val observationName = "PrivatePracticeController#udpate";
		return Observation
				.createNotStarted(observationName, observationRegistry)
				.lowCardinalityKeyValue("id", String.valueOf(id))
				.observe(() -> privatePracticeService.update(id, request));
	}
	
}