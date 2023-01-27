package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySystemOption;
import mx.softixx.cis.common.healthcare.center.payload.SystemOptionResponse;

public class SystemOptionConverter {
	
	private SystemOptionConverter() {		
	}
	
	public static SystemOptionResponse map(ClinicalEntitySystemOption systemOption) {
		if (systemOption == null) {
			return null;
		}
		
		return SystemOptionResponse
				.builder()
				.id(systemOption.getId())
				.clinicalEntityId(systemOption.getClinicalEntity().getId())
				.autoConfigSystemOptionId(systemOption.getAutoConfigSystemOptionId())
				.hash(systemOption.getHash())
				.active(systemOption.isActive())
				.build();
	}
	
}