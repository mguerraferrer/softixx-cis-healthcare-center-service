package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityService;
import mx.softixx.cis.common.healthcare.center.payload.ServiceResponse;

public final class ServiceConverter {
	
	private ServiceConverter() {		
	}
	
	public static ServiceResponse map(ClinicalEntityService service) {
		if (service == null) {
			return null;
		}
		
		return ServiceResponse
				.builder()
				.id(service.getId())
				.clinicalEntitySpecialityId(service.getClinicalEntitySpeciality().getId())
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