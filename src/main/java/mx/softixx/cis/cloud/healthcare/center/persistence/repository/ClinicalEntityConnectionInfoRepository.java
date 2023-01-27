package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAccessInfo;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityConnectionInfo;

/**
 * Repository : ClinicalEntityConnectionInfo
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityConnectionInfoRepository extends JpaRepository<ClinicalEntityConnectionInfo, Long> {

	/**
	 * Returns the ClinicalEntityConnectionInfo associated with a
	 * {@link ClinicalEntityAccessInfo} if
	 * {@link ClinicalEntityConnectionInfo#getDeleted()} is false and
	 * {@link ClinicalEntityAccessInfo#getDeleted()} is false
	 * 
	 * @param clinicalEntityAccessInfo {@link ClinicalEntityAccessInfo}
	 * @return ClinicalEntityConnectionInfo or null
	 */
	ClinicalEntityConnectionInfo findByClinicalEntityAccessInfoAndClinicalEntityAccessInfo_ActiveTrueAndActiveTrue(
			ClinicalEntityAccessInfo clinicalEntityAccessInfo);

}