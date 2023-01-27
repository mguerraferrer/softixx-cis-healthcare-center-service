package mx.softixx.cis.cloud.healthcare.center.converter.doctorclinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntityService;
import mx.softixx.cis.common.healthcare.center.payload.ServiceResponse;

public final class ServiceConverter {
	
	private ServiceConverter() {		
	}
	
	public static ServiceResponse map(DoctorClinicalEntityService service) {
		if (service == null) {
			return null;
		}
		
		return ServiceResponse
				.builder()
				.id(service.getId())
				.doctorClinicalEntitySpecialityId(service.getDoctorClinicalEntitySpeciality().getId())
				.code(service.getCode())
				.description(service.getDescription())
				.subtotal(service.getSubtotal())
				.tax(service.getTax())
				.discount(service.getDiscount())
				.total(service.getTotal())
				.discountStartDate(service.getDiscountStartDate())
				.discountDueDate(service.getDiscountDueDate())
				.active(service.isActive())
				.build();
	}
	
}