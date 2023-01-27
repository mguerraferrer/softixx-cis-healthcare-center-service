package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityEmploymentInfo;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.AccessInfoResponse.EmploymentInfoResponse;

public final class EmploymentInfoConverter {
	
	private EmploymentInfoConverter() {		
	}
	
	public static EmploymentInfoResponse map(ClinicalEntityEmploymentInfo employmentInfo) {
		if (employmentInfo == null) {
			return null;
		}
		
		return EmploymentInfoResponse
				.builder()
				.id(employmentInfo.getId())
				.accessInfoId(employmentInfo.getClinicalEntityAccessInfo().getId())
				.workingDay(employmentInfo.getWorkingDay())
				.workingDays(employmentInfo.getWorkingDays())
				.startTime(employmentInfo.getStartTime())
				.endTime(employmentInfo.getEndTime())
				.active(employmentInfo.isActive())
				.build();
	}
	
}