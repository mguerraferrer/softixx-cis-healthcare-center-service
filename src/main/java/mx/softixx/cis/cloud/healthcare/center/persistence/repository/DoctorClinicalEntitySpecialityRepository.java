package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.ClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntity;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.DoctorClinicalEntitySpeciality;

/**
 * Repository : DoctorClinicalEntitySpeciality
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface DoctorClinicalEntitySpecialityRepository extends JpaRepository<DoctorClinicalEntitySpeciality, Long> {

	/**
	 * Returns the DoctorClinicalEntitySpeciality associated with a
	 * {@link DoctorClinicalEntity} and {@link SpecialityEntity}
	 * 
	 * @param doctorClinicalEntity {@link DoctorClinicalEntity}
	 * @param specialityId         Long
	 * @return DoctorClinicalEntitySpeciality or null
	 */
	DoctorClinicalEntitySpeciality findByDoctorClinicalEntityAndDoctorClinicalEntity_ActiveTrueAndSpecialityIdAndActiveTrue(
			DoctorClinicalEntity doctorClinicalEntity, Long specialityId);

	/**
	 * Returns the list of DoctorClinicalEntitySpeciality associated with a
	 * {@link ClinicalEntity} and doctorId
	 * 
	 * @param clinicalEntity {@link ClinicalEntity}
	 * @param doctor         {@link DoctorEntity}
	 * @return {@code List<DoctorClinicalEntitySpeciality>} or empty list
	 */
	List<DoctorClinicalEntitySpeciality> findByDoctorClinicalEntity_ClinicalEntityAndDoctorClinicalEntity_DoctorIdAndDoctorClinicalEntity_ClinicalEntity_ActiveTrueAndActiveTrue(
			ClinicalEntity clinicalEntity, Long doctorId);

	/**
	 * Returns the list of DoctorClinicalEntitySpeciality associated with a doctorId
	 * 
	 * @param doctorId Long
	 * @return {@code List<DoctorClinicalEntitySpeciality>} or empty list
	 */
	List<DoctorClinicalEntitySpeciality> findByDoctorClinicalEntity_DoctorIdAndActiveTrue(Long doctorId);

}