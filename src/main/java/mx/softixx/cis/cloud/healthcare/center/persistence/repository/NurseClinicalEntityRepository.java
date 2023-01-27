package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.NurseClinicalEntity;

/**
 * Repository : NurseClinicalEntity
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface NurseClinicalEntityRepository extends JpaRepository<NurseClinicalEntity, Long> {

	/**
	 * Returns the NurseClinicalEntity that exactly matches the given id
	 * 
	 * @param id Long
	 * @return NurseClinicalEntity or null
	 */
	NurseClinicalEntity findByIdAndActiveTrue(Long id);

	/**
	 * Returns a {@code List<NurseClinicalEntity>} associated to the given nurseId
	 * 
	 * @param nurseId Long
	 * @return {@code List<NurseClinicalEntity>}
	 */
	List<NurseClinicalEntity> findByNurseIdAndActiveTrue(Long nurseId);

	/**
	 * Returns a {@code List<NurseClinicalEntity>} associated to the given
	 * {@link ClinicalEntity}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<NurseClinicalEntity>}
	 */
	List<NurseClinicalEntity> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

	/**
	 * Returns a {@code Page<NurseClinicalEntity>} object associated to the given
	 * {@link ClinicalEntity} and sorted by pageable param
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param pageable       {@link Pageable}
	 * @return {@code Page<NurseClinicalEntity>} or empty page
	 */
	Page<NurseClinicalEntity> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity, Pageable pageable);

}