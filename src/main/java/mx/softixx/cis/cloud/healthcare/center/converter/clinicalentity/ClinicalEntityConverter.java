package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import java.util.List;
import java.util.function.Predicate;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAccessInfo;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAddress;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityCustomRole;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityFunctionality;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityPreferences;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySpeciality;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntitySystemOption;
import mx.softixx.cis.common.healthcare.center.payload.AddressResponse;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.AccessInfoResponse;
import mx.softixx.cis.common.healthcare.center.payload.ClinicalEntityResponse.PreferenceResponse;
import mx.softixx.cis.common.healthcare.center.payload.CustomRoleResponse;
import mx.softixx.cis.common.healthcare.center.payload.FunctionalityResponse;
import mx.softixx.cis.common.healthcare.center.payload.SpecialityResponse;
import mx.softixx.cis.common.healthcare.center.payload.SystemOptionResponse;

public final class ClinicalEntityConverter {
	
	private ClinicalEntityConverter() {		
	}
	
	public static ClinicalEntityResponse map(ClinicalEntity clinicalEntity) {
		if (clinicalEntity == null) {
			return null;
		}
		
		return ClinicalEntityResponse
				.builder()
				.id(clinicalEntity.getId())
				.name(clinicalEntity.getName())
				.businessName(clinicalEntity.getBusinessName())
				.logo(clinicalEntity.getLogo())
				.hash(clinicalEntity.getHash())
				.active(clinicalEntity.isActive())
				.specialities(mapSpeciality(clinicalEntity.getClinicalEntitySpecialities()))
				.functionalities(mapFunctionality(clinicalEntity.getClinicalEntityFunctionalities()))
				.preferences(mapPreference(clinicalEntity.getClinicalEntityPreferenceses()))
				.systemOptions(mapSystemOption(clinicalEntity.getClinicalEntitySystemOptions()))
				.addresses(mapAddress(clinicalEntity.getClinicalEntityAddresses()))
				.customRoles(mapCustomRole(clinicalEntity.getClinicalEntityCustomRoles()))
				.accessInfos(mapAccessInfo(clinicalEntity.getClinicalEntityAccessInfos()))
				.build();
	}
	
	private static final List<SpecialityResponse> mapSpeciality(List<ClinicalEntitySpeciality> source) {
		return source.stream().map(SpecialityConverter::map).filter(specialityFilter()).toList();
	}

	private static Predicate<SpecialityResponse> specialityFilter() {
		return p -> p != null && p.isActive();
	}
	
	private static final List<FunctionalityResponse> mapFunctionality(List<ClinicalEntityFunctionality> source) {
		return source.stream().map(FunctionalityConverter::map).filter(functionalityFilter()).toList();
	}
	
	private static Predicate<FunctionalityResponse> functionalityFilter() {
		return p -> p != null && p.isActive();
	}
	
	private static final List<PreferenceResponse> mapPreference(List<ClinicalEntityPreferences> source) {
		return source.stream().map(PreferenceConverter::map).filter(preferenceFilter()).toList();
	}

	private static Predicate<PreferenceResponse> preferenceFilter() {
		return p -> p != null && p.isActive();
	}
	
	private static final List<SystemOptionResponse> mapSystemOption(List<ClinicalEntitySystemOption> source) {
		return source.stream().map(SystemOptionConverter::map).filter(sysOptFilter()).toList();
	}
	
	private static Predicate<SystemOptionResponse> sysOptFilter() {
		return p -> p != null && p.isActive();
	}
	
	private static final List<AddressResponse> mapAddress(List<ClinicalEntityAddress> source) {
		return source.stream().map(AddressConverter::map).filter(addressFilter()).toList();
	}
	
	private static Predicate<AddressResponse> addressFilter() {
		return p -> p != null && p.isActive();
	}
	
	private static final List<CustomRoleResponse> mapCustomRole(List<ClinicalEntityCustomRole> source) {
		return source.stream().map(CustomRoleConverter::map).filter(customRoleFilter()).toList();
	}
	
	private static Predicate<CustomRoleResponse> customRoleFilter() {
		return p -> p != null && p.isActive();
	}
	
	private static final List<AccessInfoResponse> mapAccessInfo(List<ClinicalEntityAccessInfo> source) {
		return source.stream().map(AccessInfoConverter::map).filter(accessInfoFilter()).toList();
	}

	private static Predicate<AccessInfoResponse> accessInfoFilter() {
		return p -> p != null && p.isActive();
	}
	
}