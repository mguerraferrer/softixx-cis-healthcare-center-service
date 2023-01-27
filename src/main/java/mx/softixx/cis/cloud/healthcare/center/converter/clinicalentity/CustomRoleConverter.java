package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityCustomRole;
import mx.softixx.cis.common.healthcare.center.payload.CustomRoleResponse;

public final class CustomRoleConverter {
	
	private CustomRoleConverter() {		
	}
	
	public static CustomRoleResponse map(ClinicalEntityCustomRole customRole) {
		if (customRole == null) {
			return null;
		}
		
		return CustomRoleResponse
				.builder()
				.id(customRole.getId())
				.clinicalEntityId(customRole.getClinicalEntity().getId())
				.code(customRole.getCode())
				.value(customRole.getValue())
				.active(customRole.isActive())
				.build();
	}
	
}