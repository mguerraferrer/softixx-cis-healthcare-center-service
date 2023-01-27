package mx.softixx.cis.cloud.healthcare.center.converter.doctorclinicalentity;

import java.util.List;
import java.util.function.Predicate;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntityService;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntitySpeciality;
import mx.softixx.cis.common.healthcare.center.payload.ServiceResponse;
import mx.softixx.cis.common.healthcare.center.payload.SpecialityResponse;

public final class SpecialityConverter {
	
	private SpecialityConverter() {
	}
	
	public static SpecialityResponse map(DoctorClinicalEntitySpeciality speciality) {
		if (speciality == null) {
			return null;
		}
		
		return SpecialityResponse
				.builder()
				.id(null)
				.doctorClinicalEntityId(null)
				.specialityId(null)
				.professionalLicense(null)
				.appointmentDuration(null)
				.active(false)
				.services(mapService(speciality.getDoctorClinicalEntityServices()))
				.build();
	}
	
	private static final List<ServiceResponse> mapService(List<DoctorClinicalEntityService> services) {
		return services.stream().map(ServiceConverter::map).filter(serviceFilter()).toList();
	}
	
	private static Predicate<ServiceResponse> serviceFilter() {
		return p -> p != null && p.isActive();
	}
	
}