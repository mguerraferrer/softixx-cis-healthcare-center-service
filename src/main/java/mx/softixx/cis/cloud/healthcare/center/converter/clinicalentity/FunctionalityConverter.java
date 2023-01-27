package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityFunctionality;
import mx.softixx.cis.common.healthcare.center.payload.FunctionalityResponse;

public class FunctionalityConverter {
	
	private FunctionalityConverter() {		
	}
	
	public static final FunctionalityResponse map(ClinicalEntityFunctionality functionality) {
		if (functionality == null) {
			return null;
		}
		
		return FunctionalityResponse
				.builder()
				.id(functionality.getId())
				.clinicalEntityId(functionality.getClinicalEntity().getId())
				.functionalityId(functionality.getFunctionalityId())
				.hash(functionality.getHash())
				.active(functionality.isActive())
				.build();
	}
	
}