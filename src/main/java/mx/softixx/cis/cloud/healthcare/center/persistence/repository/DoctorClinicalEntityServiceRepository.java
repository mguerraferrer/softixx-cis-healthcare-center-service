package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntityService;

/**
 * Repository : DoctorClinicalEntityService
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface DoctorClinicalEntityServiceRepository extends JpaRepository<DoctorClinicalEntityService, Long> {

	/**
	 * Returns the DoctorClinicalEntityService that exactly matches the given
	 * id
	 * 
	 * @param id Long
	 * @return DoctorClinicalEntityService or null
	 */
	DoctorClinicalEntityService findByIdAndActiveTrue(Long id);

}