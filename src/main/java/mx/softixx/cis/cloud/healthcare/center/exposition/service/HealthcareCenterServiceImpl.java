package mx.softixx.cis.cloud.healthcare.center.exposition.service;

import org.springframework.stereotype.Service;

import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.converter.healthcarecenter.HealthcareCenterConverter;
import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterDoctorResponse;
import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterParticipantResponse;

@Service
public class HealthcareCenterServiceImpl implements HealthcareCenterService {

	private final PrivatePracticeService privatePracticeService;
	private final DoctorClinicalEntityService doctorClinicalEntityService;
	
	public HealthcareCenterServiceImpl(PrivatePracticeService privatePracticeService,
									   DoctorClinicalEntityService doctorClinicalEntityService) {
		this.privatePracticeService = privatePracticeService;
		this.doctorClinicalEntityService = doctorClinicalEntityService;
	}

	@Override
	public HealthcareCenterDoctorResponse findByDoctor(Long doctorId) {
		val privatePractice = privatePracticeService.findByDoctor(doctorId);
		val doctorClinicalEntities = doctorClinicalEntityService.findByDoctor(doctorId);
		return HealthcareCenterConverter.map(privatePractice, doctorClinicalEntities);
	}

	@Override
	public HealthcareCenterParticipantResponse findByNurse(Long nurseId) {
		return null;
	}

	@Override
	public HealthcareCenterParticipantResponse findByAssistant(Long assistantId) {
		return null;
	}

}