package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntity;

/**
 * Repository : DoctorClinicalEntity
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface DoctorClinicalEntityRepository extends JpaRepository<DoctorClinicalEntity, Long> {

	/**
	 * Returns the {@link DoctorClinicalEntity} that exactly matches the given id
	 * 
	 * @param id Long
	 * @return DoctorClinicalEntity or null
	 */
	DoctorClinicalEntity findByIdAndActiveTrue(Long id);

	/**
	 * Returns the {@link DoctorClinicalEntity} associated with a doctor id and
	 * {@link ClinicalEntity}
	 * 
	 * @param doctorId       Long
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return DoctorClinicalEntity or null
	 */
	DoctorClinicalEntity findByDoctorIdAndClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(Long doctorId,
			ClinicalEntity clinicalEntity);

	/**
	 * Returns the {@link DoctorClinicalEntity} associated with a doctor id and
	 * {@link ClinicalEntity}
	 * 
	 * @param doctorId       Long
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return DoctorClinicalEntity or null
	 */
	DoctorClinicalEntity findByDoctorIdAndClinicalEntityIdAndActiveTrue(Long doctorId, Long clinicalEntityId);

	/**
	 * Returns the list of DoctorClinicalEntity associated with a
	 * {@link ClinicalEntity}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<DoctorClinicalEntity>} or empty list
	 */
	List<DoctorClinicalEntity> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

	/**
	 * Returns the list of DoctorClinicalEntity associated with a doctor id
	 * 
	 * @param doctorId Long
	 * @return {@code List<DoctorClinicalEntity>} or empty list
	 */
	List<DoctorClinicalEntity> findByDoctorIdAndActiveTrue(Long doctorId);

	/**
	 * Returns a {@code Page<DoctorClinicalEntity>} object sorted by the pageable
	 * param if {@link DoctorClinicalEntity#getDoctorId()} is equal to doctor param
	 * 
	 * @param doctorId Long
	 * @param pageable {@link Pageable}
	 * @return {@code Page<DoctorClinicalEntity>} or empty page
	 */
	Page<DoctorClinicalEntity> findByDoctorIdAndActiveTrue(Long doctorId, Pageable pageable);

	/**
	 * Returns a {@code Page<DoctorClinicalEntity>} object sorted by the pageable
	 * param if {@link DoctorClinicalEntity#getClinicalEntity()} is equal to
	 * clinicalEntity param
	 * 
	 * @param clinicalEntity {@link getClinicalEntity}
	 * @param pageable       {@link Pageable}
	 * @return {@code Page<DoctorClinicalEntity>} or empty page
	 */
	Page<DoctorClinicalEntity> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity, Pageable pageable);

}