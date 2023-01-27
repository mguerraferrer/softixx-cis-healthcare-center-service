package mx.softixx.cis.cloud.healthcare.center.converter.doctorclinicalentity;

import java.util.List;
import java.util.function.Predicate;

import mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity.ClinicalEntityConverter;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntitySpeciality;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse;
import mx.softixx.cis.common.healthcare.center.payload.DoctorClinicalEntityResponse;
import mx.softixx.cis.common.healthcare.center.payload.SpecialityResponse;

public final class DoctorClinicalEntityConverter {
	
	private DoctorClinicalEntityConverter() {		
	}
	
	public static final DoctorClinicalEntityResponse map(DoctorClinicalEntity doctorClinicalEntity) {
		if (doctorClinicalEntity == null) {
			return null;
		}
		
		return DoctorClinicalEntityResponse
				.builder()
				.id(doctorClinicalEntity.getId())
				.doctorId(doctorClinicalEntity.getDoctorId())
				.clinicalEntity(convertClinicalEntity(doctorClinicalEntity.getClinicalEntity()))
				.active(doctorClinicalEntity.isActive())
				.specialities(mapSpeciality(doctorClinicalEntity.getDoctorClinicalEntitySpecialities()))
				.build();
	}
	
	private static final ClinicalEntityResponse convertClinicalEntity(ClinicalEntity clinicalEntity) {
		return ClinicalEntityConverter.map(clinicalEntity);
	}

	private static final List<SpecialityResponse> mapSpeciality(List<DoctorClinicalEntitySpeciality> services) {
		return services.stream().map(SpecialityConverter::map).filter(specialityFilter()).toList();
	}

	private static Predicate<SpecialityResponse> specialityFilter() {
		return p -> p != null && p.isActive();
	}
	
}