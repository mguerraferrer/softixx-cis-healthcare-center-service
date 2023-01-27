package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityPreferences;

/**
 * Repository : ClinicalEntityPreferences
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityPreferencesRepository extends JpaRepository<ClinicalEntityPreferences, Long> {

	/**
	 * Returns the ClinicalEntityPreferences associated with a
	 * {@link ClinicalEntity} if {@link ClinicalEntity#getActive()} is true,
	 * {@link ClinicalEntity#getDeleted()} is false and
	 * {@link ClinicalEntityPreferences#getDeleted()} is false
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return ClinicalEntityPreferences or null
	 */
	ClinicalEntityPreferences findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

}