package mx.softixx.cis.cloud.healthcare.center.exposition.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.converter.privatepractice.PrivatePracticeConverter;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.repository.PrivatePracticeRepository;
import mx.softixx.cis.common.healthcare.center.exception.PrivatePracticeAlreadyExistsException;
import mx.softixx.cis.common.healthcare.center.exception.PrivatePracticeNotFoundException;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeRequest;
import mx.softixx.cis.common.healthcare.center.payload.PrivatePracticeResponse;

@Service
@Transactional(readOnly = true)
public class PrivatePracticeServiceImpl implements PrivatePracticeService {

	private final PrivatePracticeRepository privatePracticeRepository;
	
	public PrivatePracticeServiceImpl(PrivatePracticeRepository privatePracticeRepository) {
		this.privatePracticeRepository = privatePracticeRepository;
	}

	@Override
	public PrivatePracticeResponse findByDoctor(Long doctorId) {
		return privatePracticeRepository.findByDoctorIdAndActiveTrue(doctorId)
										.map(PrivatePracticeConverter::map)
										.orElse(null);
	}

	@Override
	@Transactional
	public PrivatePracticeResponse create(PrivatePracticeRequest request) {
		verifyIfExists(request.getDoctorId());
		val privatePractice = PrivatePracticeConverter.map(request);
		
		save(privatePractice);
		return PrivatePracticeConverter.map(privatePractice);
	}
	
	@Override
	@Transactional
	public PrivatePracticeResponse update(Long id, PrivatePracticeRequest request) {
		val privatePractice = findById(id);
		PrivatePracticeConverter.map(privatePractice, request);
		
		save(privatePractice);
		return PrivatePracticeConverter.map(privatePractice);
	}
	
	private void verifyIfExists(Long doctorId) {
		val privatePracticeByDoctor = privatePracticeRepository.findByDoctorId(doctorId).orElse(null);
		if (privatePracticeByDoctor != null) {
			throw new PrivatePracticeAlreadyExistsException();
		}
	}
	
	private PrivatePractice findById(Long id) {
		return privatePracticeRepository.findById(id).orElseThrow(PrivatePracticeNotFoundException::new);
	}
	
	private PrivatePractice save(PrivatePractice privatePractice) {
		if (privatePractice != null) {
			return privatePracticeRepository.save(privatePractice);
		}
		return null;
	}

}