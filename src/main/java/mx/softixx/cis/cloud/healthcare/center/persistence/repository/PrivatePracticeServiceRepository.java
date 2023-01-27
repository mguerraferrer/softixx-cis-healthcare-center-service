package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeService;

/**
 * Repository : PrivatePracticeService
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PrivatePracticeServiceRepository extends JpaRepository<PrivatePracticeService, Long> {

	/**
	 * Returns the PrivatePracticeService that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PrivatePracticeService or null
	 */
	PrivatePracticeService findByIdAndActiveTrue(Long id);

	/**
	 * Returns the list of PrivatePracticeService associated with a
	 * {@link PrivatePractice} and doctor speciality id if
	 * {@link PrivatePracticeService#isActive()} is false
	 * 
	 * @param privatePractice    {@link PrivatePractice}
	 * @param doctorSpecialityId Long
	 * @return {@code List<PrivatePracticeService>} or empty list
	 */
	List<PrivatePracticeService> findByPrivatePracticeAndDoctorSpecialityIdAndActiveTrue(
			PrivatePractice privatePractice, Long doctorSpecialityId);

	/**
	 * Returns the list of PrivatePracticeService associated with a
	 * {@link PrivatePractice} if {@link PrivatePracticeService#getDeleted()} is
	 * false
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @return {@code List<PrivatePracticeService>} or empty list
	 */
	List<PrivatePracticeService> findByPrivatePracticeAndActiveTrue(PrivatePractice privatePractice);

}