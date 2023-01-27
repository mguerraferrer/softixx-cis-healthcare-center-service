package mx.softixx.cis.cloud.healthcare.center.converter.healthcarecenter;

import java.util.List;

import mx.softixx.cis.common.healthcare.center.payload.DoctorClinicalEntityResponse;
import mx.softixx.cis.common.healthcare.center.payload.HealthcareCenterDoctorResponse;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeResponse;

public final class HealthcareCenterConverter {
	
	private HealthcareCenterConverter() {		
	}
	
	public static HealthcareCenterDoctorResponse map(PrivatePracticeResponse privatePractice, 
														 List<DoctorClinicalEntityResponse> doctorClinicalEntities) {
		return new HealthcareCenterDoctorResponse(privatePractice, doctorClinicalEntities);
	}
	
}