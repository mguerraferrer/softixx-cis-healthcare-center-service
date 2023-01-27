package mx.softixx.cis.cloud.healthcare.center.converter.privatepractice;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeSystemOption;
import mx.softixx.cis.common.healthcare.center.payload.SystemOptionResponse;

public class SystemOptionConverter {
	
	private SystemOptionConverter() {		
	}
	
	public static SystemOptionResponse map(PrivatePracticeSystemOption systemOption) {
		if (systemOption == null) {
			return null;
		}
		
		return SystemOptionResponse
				.builder()
				.id(systemOption.getId())
				.privatePracticeId(systemOption.getPrivatePractice().getId())
				.autoConfigSystemOptionId(systemOption.getAutoConfigSystemOptionId())
				.hash(systemOption.getHash())
				.active(systemOption.isActive())
				.build();
	}
	
}