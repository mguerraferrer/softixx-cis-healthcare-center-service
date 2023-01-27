package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAccessInfo;

/**
 * Repository : ClinicalEntityAccessInfo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityAccessInfoRepository extends JpaRepository<ClinicalEntityAccessInfo, Long> {

	/**
	 * Returns the ClinicalEntityAccessInfo associated with a {@link ClinicalEntity}
	 * and {@link ProfileEntity} if {@link ClinicalEntity#getDeleted()} is false,
	 * {@link ProfileEntity#getDeleted()} and
	 * {@link ClinicalEntityAccessInfo#getDeleted()} is false
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param profileId      Long
	 * @return ClinicalEntityAccessInfo or null
	 */
	ClinicalEntityAccessInfo findByClinicalEntityAndProfileIdAndClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity, Long profileId);

}