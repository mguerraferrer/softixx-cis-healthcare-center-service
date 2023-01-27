package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAccessInfo;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityEmploymentInfo;

/**
 * Repository : ClinicalEntityEmploymentInfo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityEmploymentInfoRepository extends JpaRepository<ClinicalEntityEmploymentInfo, Long> {

	/**
	 * Returns the ClinicalEntityEmploymentInfo associated with a
	 * {@link ClinicalEntityEmploymentInfo} if
	 * {@link ClinicalEntityEmploymentInfo#getDeleted()} is false and
	 * {@link ClinicalEntityAccessInfo#getDeleted()} is false
	 * 
	 * @param clinicalEntityAccessInfo
	 * @return ClinicalEntityConnectionInfo or null
	 */
	ClinicalEntityEmploymentInfo findByClinicalEntityAccessInfoAndClinicalEntityAccessInfo_ActiveTrueAndActiveTrue(
			ClinicalEntityAccessInfo clinicalEntityAccessInfo);

}