package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.AssistantClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;

/**
 * Repository : AssistantClinicalEntity
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface AssistantClinicalEntityRepository extends JpaRepository<AssistantClinicalEntity, Long> {

	/**
	 * Returns the AssistantClinicalEntity that exactly matches the given id
	 * 
	 * @param id Long
	 * @return AssistantClinicalEntity or null
	 */
	AssistantClinicalEntity findByIdAndActiveTrue(Long id);

	/**
	 * Returns a {@code List<AssistantClinicalEntity>} associated to the given
	 * assistantId
	 * 
	 * @param assistantId Long
	 * @return {@code List<AssistantClinicalEntity>}
	 */
	List<AssistantClinicalEntity> findByAssistantIdAndActiveTrue(Long assistantId);

	/**
	 * Returns a {@code List<AssistantClinicalEntity>} associated to the given
	 * {@link ClinicalEntity}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<AssistantClinicalEntity>}
	 */
	List<AssistantClinicalEntity> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

	/**
	 * Returns a {@code Page<AssistantClinicalEntity>} object associated to the
	 * given {@link ClinicalEntity} and sorted by pageable param
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param pageable       {@link Pageable}
	 * @return {@code Page<AssistantClinicalEntity>} or empty page
	 */
	Page<AssistantClinicalEntity> findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity, Pageable pageable);

}