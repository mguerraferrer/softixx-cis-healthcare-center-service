package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityConnectionInfo;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.AccessInfoResponse.ConnectionInfoResponse;

public final class ConnectionInfoConverter {

	private ConnectionInfoConverter() {		
	}
	
	public static ConnectionInfoResponse map(ClinicalEntityConnectionInfo connectionInfo) {
		if (connectionInfo == null) {
			return null;
		}
		
		return ConnectionInfoResponse
				.builder()
				.id(connectionInfo.getId())
				.accessInfoId(connectionInfo.getClinicalEntityAccessInfo().getId())
				.ip(connectionInfo.getIp())
				.ipRangeStart(connectionInfo.getIpRangeStart())
				.ipRangeEnd(connectionInfo.getIpRangeEnd())
				.active(connectionInfo.isActive())
				.build();
	}
	
}