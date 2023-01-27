package mx.softixx.cis.cloud.healthcare.center.converter.privatepractice;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeService;
import mx.softixx.cis.common.healthcare.center.payload.ServiceResponse;

public final class ServiceConverter {
	
	private ServiceConverter() {		
	}
	
	public static ServiceResponse map(PrivatePracticeService service) {
		if (service == null) {
			return null;
		}
		
		return ServiceResponse
				.builder()
				.id(service.getId())
				.privatePracticeId(service.getPrivatePractice().getId())
				.doctorSpecialityId(service.getDoctorSpecialityId())
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