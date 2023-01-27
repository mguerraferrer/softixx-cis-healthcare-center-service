package mx.softixx.cis.cloud.healthcare.center.exposition.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.val;
import mx.softixx.cis.cloud.healthcare.center.converter.doctorclinicalentity.DoctorClinicalEntityConverter;
import mx.softixx.cis.cloud.healthcare.center.persistence.repository.DoctorClinicalEntityRepository;
import mx.softixx.cis.common.healthcare.center.payload.DoctorClinicalEntityResponse;

@Service
public class DoctorClinicalEntityServiceImpl implements DoctorClinicalEntityService {

	private final DoctorClinicalEntityRepository doctorClinicalEntityRepository;

	public DoctorClinicalEntityServiceImpl(DoctorClinicalEntityRepository doctorClinicalEntityRepository) {
		this.doctorClinicalEntityRepository = doctorClinicalEntityRepository;
	}

	@Override
	public List<DoctorClinicalEntityResponse> findByDoctor(Long doctorId) {
		val source = doctorClinicalEntityRepository.findByDoctorIdAndActiveTrue(doctorId);
		return source.stream().map(DoctorClinicalEntityConverter::map).toList();
	}

	@Override
	public DoctorClinicalEntityResponse findByDoctorAndClinicalEntity(Long doctorId, Long clinicalEntityId) {
		val doctorClinicalEntity = doctorClinicalEntityRepository
				.findByDoctorIdAndClinicalEntityIdAndActiveTrue(doctorId, clinicalEntityId);
		return DoctorClinicalEntityConverter.map(doctorClinicalEntity);
	}

}