package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityPreferences;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.PreferenceResponse;

public final class PreferenceConverter {
	
	private PreferenceConverter() {		
	}
	
	public static PreferenceResponse map(ClinicalEntityPreferences preferences) {
		if (preferences == null) {
			return null;
		}
		
		return PreferenceResponse
				.builder()
				.id(preferences.getId())
				.clinicalEntityId(preferences.getClinicalEntity().getId())
				.paged(preferences.getPaged())
				.ip(preferences.getIp())
				.ipRangeStart(preferences.getIpRangeStart())
				.ipRangeEnd(preferences.getIpRangeEnd())
				.pwdExpiration(preferences.getPwdExpiration())
				.active(preferences.isActive())
				.build();
	}
	
}