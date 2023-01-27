package mx.softixx.cis.cloud.healthcare.center.converter.privatepractice;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeFunctionality;
import mx.softixx.cis.common.healthcare.center.payload.FunctionalityResponse;

public class FunctionalityConverter {
	
	private FunctionalityConverter() {		
	}
	
	public static final FunctionalityResponse map(PrivatePracticeFunctionality functionality) {
		if (functionality == null) {
			return null;
		}
		
		return FunctionalityResponse
				.builder()
				.id(functionality.getId())
				.privatePracticeId(functionality.getPrivatePractice().getId())
				.functionalityId(functionality.getFunctionalityId())
				.hash(functionality.getHash())
				.active(functionality.isActive())
				.build();
	}
	
}