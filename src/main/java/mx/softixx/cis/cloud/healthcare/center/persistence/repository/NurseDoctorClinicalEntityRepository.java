package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.NurseDoctorClinicalEntity;

/**
 * Repository : NurseClinicalEntity
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface NurseDoctorClinicalEntityRepository extends JpaRepository<NurseDoctorClinicalEntity, Long> {

	/**
	 * Returns the NurseDoctorClinicalEntity that exactly matches the given id
	 * 
	 * @param id Long
	 * @return NurseDoctorClinicalEntity or null
	 */
	NurseDoctorClinicalEntity findByIdAndActiveTrue(Long id);

	/**
	 * Returns a {@code List<NurseDoctorClinicalEntity>} associated to the given
	 * nurseId
	 * 
	 * @param nurseId Long
	 * @return {@code List<NurseDoctorClinicalEntity>}
	 */
	List<NurseDoctorClinicalEntity> findByNurseClinicalEntity_NurseIdAndActiveTrue(Long nurseId);

	/**
	 * Returns the {@code List<NurseDoctorClinicalEntity>} that exactly matches the
	 * given {@link DoctorClinicalEntity} and Long
	 * 
	 * @param doctorClinicalEntity {@link DoctorClinicalEntity}
	 * @param clinicalEntityId     Long
	 * @return {@code List<NurseDoctorClinicalEntity>}
	 */
	List<NurseDoctorClinicalEntity> findByDoctorClinicalEntityAndDoctorClinicalEntity_ActiveTrueAndDoctorClinicalEntity_ClinicalEntityIdAndActiveTrue(
			DoctorClinicalEntity doctorClinicalEntity, Long clinicalEntityId);

	/**
	 * Returns a {@code List<NurseDoctorClinicalEntity>} associated to the given
	 * Long
	 * 
	 * @param clinicalEntityId Long
	 * @return {@code List<NurseDoctorClinicalEntity>}
	 */
	List<NurseDoctorClinicalEntity> findByNurseClinicalEntity_ClinicalEntityIdAndActiveTrue(Long clinicalEntityId);

	/**
	 * Returns a {@code Page<NurseDoctorClinicalEntity>} object associated to the
	 * given Long and sorted by pageable param
	 * 
	 * @param clinicalEntityId Long
	 * @param pageable         {@link Pageable}
	 * @return {@code Page<NurseDoctorClinicalEntity>} or empty page
	 */
	Page<NurseDoctorClinicalEntity> findByNurseClinicalEntity_ClinicalEntityIdAndActiveTrue(Long clinicalEntityId,
			Pageable pageable);

}