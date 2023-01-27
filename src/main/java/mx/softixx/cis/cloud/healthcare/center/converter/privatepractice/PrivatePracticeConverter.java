package mx.softixx.cis.cloud.healthcare.center.converter.privatepractice;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.util.ObjectUtils;

import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeAddress;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeCustomRole;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeFunctionality;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeService;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeSystemOption;
import mx.softixx.cis.common.healthcare.center.payload.AddressResponse;
import mx.softixx.cis.common.healthcare.center.payload.CustomRoleResponse;
import mx.softixx.cis.common.healthcare.center.payload.FunctionalityResponse;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeRequest;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeResponse;
import mx.softixx.cis.common.healthcare.center.payload.ServiceResponse;
import mx.softixx.cis.common.healthcare.center.payload.SystemOptionResponse;

public final class PrivatePracticeConverter {
	
	private PrivatePracticeConverter() {	
	}
	
	public static PrivatePracticeResponse map(PrivatePractice privatePractice) {
		if (privatePractice == null) {
			return null;
		}
		
		return PrivatePracticeResponse
				.builder()
				.id(privatePractice.getId())
				.doctorId(privatePractice.getDoctorId())
				.doctorName(privatePractice.getDoctorName())
				.hash(privatePractice.getHash())
				.active(privatePractice.isActive())
				.functionalities(mapFunctionality(privatePractice.getPrivatePracticeFunctionalities()))
				.services(mapService(privatePractice.getPrivatePracticeServices()))
				.systemOptions(mapSystemOption(privatePractice.getPrivatePracticeSystemOptions()))
				.addresses(mapAddress(privatePractice.getPrivatePracticeAddresses()))
				.customRoles(mapCustomRole(privatePractice.getPrivatePracticeCustomRoles()))
				.build();
	}
	
	public static PrivatePractice map(PrivatePracticeRequest request) {
		if (request == null) {
			return null;
		}
		
		val isActive = request.isActive() != null ? request.isActive() : true;
		return new PrivatePractice(request.getDoctorId(), request.getDoctorName(), isActive);
	}
	
	public static void map(final PrivatePractice privatePractice, final PrivatePracticeRequest request) {
		if (request != null) {
			if (!ObjectUtils.isEmpty(request.getDoctorId())) {
				privatePractice.setDoctorId(request.getDoctorId());
			}
			
			if (!ObjectUtils.isEmpty(request.getDoctorName())) {
				privatePractice.setDoctorName(request.getDoctorName());
			}
			
			if (!ObjectUtils.isEmpty(request.isActive())) {
				privatePractice.setActive(request.isActive());
			}
		}
	}
	
	private static final List<FunctionalityResponse> mapFunctionality(List<PrivatePracticeFunctionality> source) {
		return source.stream().map(FunctionalityConverter::map).filter(functionalityFilter()).toList();
	}

	private static Predicate<FunctionalityResponse> functionalityFilter() {
		return p -> p != null && p.isActive();
	}

	private static final List<ServiceResponse> mapService(List<PrivatePracticeService> source) {
		return source.stream().map(ServiceConverter::map).filter(serviceFilter()).toList();
	}

	private static Predicate<ServiceResponse> serviceFilter() {
		return p -> p != null && p.isActive();
	}

	private static final List<SystemOptionResponse> mapSystemOption(List<PrivatePracticeSystemOption> source) {
		return source.stream().map(SystemOptionConverter::map).filter(sysOptFilter()).toList();
	}

	private static Predicate<SystemOptionResponse> sysOptFilter() {
		return p -> p != null && p.isActive();
	}

	private static final List<AddressResponse> mapAddress(List<PrivatePracticeAddress> source) {
		return source.stream().map(AddressConverter::map).filter(addressFilter()).toList();
	}

	private static Predicate<AddressResponse> addressFilter() {
		return p -> p != null && p.isActive();
	}

	private static final List<CustomRoleResponse> mapCustomRole(List<PrivatePracticeCustomRole> source) {
		return source.stream().map(CustomRoleConverter::map).filter(customRoleFilter()).toList();
	}

	private static Predicate<CustomRoleResponse> customRoleFilter() {
		return p -> p != null && p.isActive();
	}

}