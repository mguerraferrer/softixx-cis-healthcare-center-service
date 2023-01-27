package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import java.util.List;
import java.util.function.Predicate;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAccessInfo;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityConnectionInfo;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityEmploymentInfo;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.AccessInfoResponse;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.AccessInfoResponse.ConnectionInfoResponse;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.AccessInfoResponse.EmploymentInfoResponse;

public final class AccessInfoConverter {
	
	private AccessInfoConverter() {		
	}
	
	public static AccessInfoResponse map(ClinicalEntityAccessInfo accessInfo) {
		if (accessInfo == null) {
			return null;
		}
		
		return AccessInfoResponse
				.builder()
				.id(null)
				.clinicalEntityId(null)
				.profileId(null)
				.accessLevelId(null)
				.active(false)
				.employmentInfos(mapEmploymentInfo(accessInfo.getClinicalEntityEmploymentInfos()))
				.connectionInfos(mapConnectionInfo(accessInfo.getClinicalEntityConnectionInfos()))
				.build();
	}
	
	private static final List<EmploymentInfoResponse> mapEmploymentInfo(List<ClinicalEntityEmploymentInfo> source) {
		return source.stream().map(EmploymentInfoConverter::map).filter(employmentInfoFilter()).toList();
	}

	private static Predicate<EmploymentInfoResponse> employmentInfoFilter() {
		return p -> p != null && p.isActive();
	}

	private static final List<ConnectionInfoResponse> mapConnectionInfo(List<ClinicalEntityConnectionInfo> source) {
		return source.stream().map(ConnectionInfoConverter::map).filter(connectionInfoFilter()).toList();
	}

	private static Predicate<ConnectionInfoResponse> connectionInfoFilter() {
		return p -> p != null && p.isActive();
	}
	
}