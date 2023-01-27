package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityContactInfo;

/**
 * Repository : ClinicalEntityContactInfo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityContactInfoRepository extends JpaRepository<ClinicalEntityContactInfo, Long> {

	/**
	 * Returns the ClinicalEntityContactInfo associated with a
	 * {@link ClinicalEntity} if {@link ClinicalEntity#getDeleted()} is false and
	 * {@link ClinicalEntityContactInfo#getDeleted()} is false
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return ClinicalEntityContactInfo or null
	 */
	ClinicalEntityContactInfo findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity);

}