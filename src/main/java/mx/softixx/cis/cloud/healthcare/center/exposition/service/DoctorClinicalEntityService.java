package mx.softixx.cis.cloud.healthcare.center.exposition.service;

import java.util.List;

import mx.softixx.cis.common.healthcare.center.payload.DoctorClinicalEntityResponse;

public interface DoctorClinicalEntityService {

	List<DoctorClinicalEntityResponse> findByDoctor(Long doctorId);
	
	DoctorClinicalEntityResponse findByDoctorAndClinicalEntity(Long doctorId, Long clinicalEntityId);
	
}