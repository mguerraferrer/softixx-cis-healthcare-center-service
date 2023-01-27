package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import java.util.List;
import java.util.function.Predicate;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityService;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySpeciality;
import mx.softixx.cis.common.healthcare.center.payload.ServiceResponse;
import mx.softixx.cis.common.healthcare.center.payload.SpecialityResponse;

public final class SpecialityConverter {
	
	private SpecialityConverter() {
	}
	
	public static SpecialityResponse map(ClinicalEntitySpeciality speciality) {
		if (speciality == null) {
			return null;
		}
		
		return SpecialityResponse
				.builder()
				.id(speciality.getId())
				.clinicalEntityId(speciality.getClinicalEntity().getId())
				.specialityId(speciality.getSpecialityId())
				.hash(speciality.getHash())
				.active(speciality.isActive())
				.services(mapService(speciality.getClinicalEntityServices()))
				.build();
	}
	
	private static final List<ServiceResponse> mapService(List<ClinicalEntityService> source) {
		return source.stream().map(ServiceConverter::map).filter(serviceFilter()).toList();
	}
	
	private static Predicate<ServiceResponse> serviceFilter() {
		return p -> p != null && p.isActive();
	}
	
}