package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.AssistantDoctorClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntity;

/**
 * Repository : AssistantClinicalEntity
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface AssistantDoctorClinicalEntityRepository extends JpaRepository<AssistantDoctorClinicalEntity, Long> {

	/**
	 * Returns the AssistantDoctorClinicalEntity that exactly matches the given id
	 * 
	 * @param id Long
	 * @return AssistantDoctorClinicalEntity or null
	 */
	AssistantDoctorClinicalEntity findByIdAndActiveTrue(Long id);

	/**
	 * Returns a {@code List<AssistantDoctorClinicalEntity>} associated to the given
	 * asistantId
	 * 
	 * @param assistantId Long
	 * @return {@code List<AssistantDoctorClinicalEntity>}
	 */
	List<AssistantDoctorClinicalEntity> findByAssistantClinicalEntity_AssistantIdAndActiveTrue(Long assistantId);

	/**
	 * Returns the {@code List<AssistantDoctorClinicalEntity>} that exactly matches
	 * the given {@link DoctorClinicalEntity} and {@link ClinicalEntity}
	 * 
	 * @param doctorClinicalEntity {@link DoctorClinicalEntity}
	 * @param clinicalEntity       {@link ClinicalEntity}
	 * @return {@code List<AssistantDoctorClinicalEntity>}
	 */
	List<AssistantDoctorClinicalEntity> findByDoctorClinicalEntityAndDoctorClinicalEntity_ActiveTrueAndDoctorClinicalEntity_ClinicalEntityAndDoctorClinicalEntity_ClinicalEntity_ActiveTrueAndActiveTrue(
			DoctorClinicalEntity doctorClinicalEntity, ClinicalEntity clinicalEntity);

	/**
	 * Returns a {@code List<AssistantDoctorClinicalEntity>} associated to the given
	 * {@link ClinicalEntity}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return {@code List<AssistantDoctorClinicalEntity>}
	 */
	List<AssistantDoctorClinicalEntity> findByAssistantClinicalEntity_ClinicalEntityAndAssistantClinicalEntity_ClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

	/**
	 * Returns a {@code Page<AssistantDoctorClinicalEntity>} object associated to
	 * the given {@link ClinicalEntity} and sorted by pageable param
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param pageable       {@link Pageable}
	 * @return {@code Page<AssistantDoctorClinicalEntity>} or empty page
	 */
	Page<AssistantDoctorClinicalEntity> findByAssistantClinicalEntity_ClinicalEntityAndAssistantClinicalEntity_ClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity, Pageable pageable);

}