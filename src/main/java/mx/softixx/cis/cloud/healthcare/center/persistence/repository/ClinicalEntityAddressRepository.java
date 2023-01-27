package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntityAddress;

/**
 * Repository : ClinicalEntityAddress
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface ClinicalEntityAddressRepository extends JpaRepository<ClinicalEntityAddress, Long> {

	/**
	 * Returns the ClinicalEntityAddress that exactly matches the given id
	 * 
	 * @param id Long
	 * @return ClinicalEntityAddress or null
	 */
	ClinicalEntityAddress findByIdAndActiveTrue(Long id);

	/**
	 * Returns the ClinicalEntityAddress associated with {@link ClinicalEntity}
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @return ClinicalEntityAddress or null
	 */
	ClinicalEntityAddress findByClinicalEntityAndClinicalEntity_ActiveTrueAndActiveTrue(ClinicalEntity clinicalEntity);

}