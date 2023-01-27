package mx.softixx.cis.cloud.healthcare.center.exposition.service;

import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeRequest;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeResponse;

public interface PrivatePracticeService {
	
	PrivatePracticeResponse findByDoctor(Long doctorId);
	
	PrivatePracticeResponse create(PrivatePracticeRequest request);
	
	PrivatePracticeResponse update(Long id, PrivatePracticeRequest request);
	
}