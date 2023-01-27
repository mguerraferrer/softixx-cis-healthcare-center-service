package mx.softixx.cis.cloud.healthcare.center.exposition.service;

import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterDoctorResponse;
import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterParticipantResponse;

public interface HealthcareCenterService {
	
	HealthcareCenterDoctorResponse findByDoctor(Long doctorId);
	
	HealthcareCenterParticipantResponse findByNurse(Long nurseId);
	
	HealthcareCenterParticipantResponse findByAssistant(Long assistantId);
	
}