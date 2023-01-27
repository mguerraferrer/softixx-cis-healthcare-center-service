package mx.softixx.cis.cloud.healthcare.center.converter.privatepractice;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeCustomRole;
import mx.softixx.cis.common.healthcare.center.payload.CustomRoleResponse;

public final class CustomRoleConverter {
	
	private CustomRoleConverter() {		
	}
	
	public static CustomRoleResponse map(PrivatePracticeCustomRole customRole) {
		if (customRole == null) {
			return null;
		}
		
		return CustomRoleResponse
				.builder()
				.id(customRole.getId())
				.privatePracticeId(customRole.getPrivatePractice().getId())
				.code(customRole.getCode())
				.value(customRole.getValue())
				.active(customRole.isActive())
				.build();
	}
	
}