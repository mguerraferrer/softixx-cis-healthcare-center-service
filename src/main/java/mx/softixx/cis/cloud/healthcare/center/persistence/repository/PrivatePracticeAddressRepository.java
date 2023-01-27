package mx.softixx.cis.cloud.healthcare.center.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePractice;
import mx.softixx.cis.cloud.healthcare.center.persistence.model.PrivatePracticeAddress;

/**
 * Repository : PrivatePracticeAddress
 * 
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 * 
 */
public interface PrivatePracticeAddressRepository extends JpaRepository<PrivatePracticeAddress, Long> {

	/**
	 * Returns the PrivatePracticeAddress that exactly matches the given id
	 * 
	 * @param id Long
	 * @return PrivatePracticeAddress or null
	 */
	PrivatePracticeAddress findByIdAndActiveTrue(Long id);

	/**
	 * Returns the PrivatePracticeAddress associated with a
	 * {@link PrivatePractice} if {@link PrivatePractice#getActive()}
	 * true, {@link PrivatePractice#isActive()} is true and
	 * {@link PrivatePracticeAddress#isActive()} is true
	 * 
	 * @param privatePractice {@link PrivatePractice}
	 * @return PrivatePracticeAddress or null
	 */
	PrivatePracticeAddress findByPrivatePracticeAndPrivatePractice_ActiveTrueAndActiveTrue(
			PrivatePractice privatePractice);

}