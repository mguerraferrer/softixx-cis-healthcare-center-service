package mx.softixx.cis.cloud.healthcare.center.converter.clinicalentity;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAddress;
import mx.softixx.cis.common.healthcare.center.payload.AddressResponse;

public final class AddressConverter {
	
	private AddressConverter() {		
	}
	
	public static AddressResponse map(ClinicalEntityAddress address) {
		if (address == null) {
			return null;
		}
		
		return AddressResponse
				.builder()
				.clinicalEntityId(address.getClinicalEntity().getId())
				.colonyMxId(address.getColonyMxId())
				.street(address.getStreet())
			    .btwStreet(address.getBtwStreet())
			    .outsideNumber(address.getOutsideNumber())
			    .insideNumber(address.getInsideNumber())
			    .reference(address.getReference())
			    .lat(address.getLat())
			    .lon(address.getLon())
			    .active(address.isActive())
				.build();
	} 
	
}