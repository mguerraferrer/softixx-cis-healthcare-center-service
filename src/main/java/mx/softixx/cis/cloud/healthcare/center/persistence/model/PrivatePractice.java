package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.encryptor.converter.AttributeEncryptor;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "private_practice"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "private_practice", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_id_seq", allocationSize = 1)
public class PrivatePractice extends BaseEntity {

	@Column(name = "doctor_id")
	private Long doctorId;

	@Column(name = "doctor_name")
	@Convert(converter = AttributeEncryptor.class)
	private String doctorName;

	@Column(name = "hash", nullable = false, length = 50)
	private String hash;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "privatePractice", targetEntity = PrivatePracticeService.class)
	private List<PrivatePracticeService> privatePracticeServices;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "privatePractice", targetEntity = PrivatePracticeCustomRole.class)
	private List<PrivatePracticeCustomRole> privatePracticeCustomRoles;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "privatePractice", targetEntity = PrivatePracticeAddress.class)
	private List<PrivatePracticeAddress> privatePracticeAddresses;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "privatePractice", targetEntity = PrivatePracticeSystemOption.class)
	private List<PrivatePracticeSystemOption> privatePracticeSystemOptions;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "privatePractice", targetEntity = PrivatePracticeFunctionality.class)
	private List<PrivatePracticeFunctionality> privatePracticeFunctionalities;

	public PrivatePractice() {
	}

	public PrivatePractice(Long doctorId, String doctorName, boolean active) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = active;
	}

	/* Getters and Setters */
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<PrivatePracticeService> getPrivatePracticeServices() {
		if (privatePracticeServices == null) {
			privatePracticeServices = new ArrayList<>();
		}
		return privatePracticeServices;
	}

	public void setPrivatePracticeServices(List<PrivatePracticeService> privatePracticeServices) {
		this.privatePracticeServices = privatePracticeServices;
	}

	public List<PrivatePracticeCustomRole> getPrivatePracticeCustomRoles() {
		if (privatePracticeCustomRoles == null) {
			privatePracticeCustomRoles = new ArrayList<>();
		}
		return privatePracticeCustomRoles;
	}

	public void setPrivatePracticeCustomRoles(List<PrivatePracticeCustomRole> privatePracticeCustomRoles) {
		this.privatePracticeCustomRoles = privatePracticeCustomRoles;
	}

	public List<PrivatePracticeAddress> getPrivatePracticeAddresses() {
		if (privatePracticeAddresses == null) {
			privatePracticeAddresses = new ArrayList<>();
		}
		return privatePracticeAddresses;
	}

	public void setPrivatePracticeAddresses(List<PrivatePracticeAddress> privatePracticeAddresses) {
		this.privatePracticeAddresses = privatePracticeAddresses;
	}

	public List<PrivatePracticeSystemOption> getPrivatePracticeSystemOptions() {
		if (privatePracticeSystemOptions == null) {
			privatePracticeSystemOptions = new ArrayList<>();
		}
		return privatePracticeSystemOptions;
	}

	public void setPrivatePracticeSystemOptions(List<PrivatePracticeSystemOption> privatePracticeSystemOptions) {
		this.privatePracticeSystemOptions = privatePracticeSystemOptions;
	}

	public List<PrivatePracticeFunctionality> getPrivatePracticeFunctionalities() {
		if (privatePracticeFunctionalities == null) {
			privatePracticeFunctionalities = new ArrayList<>();
		}
		return privatePracticeFunctionalities;
	}

	public void setPrivatePracticeFunctionalities(List<PrivatePracticeFunctionality> privatePracticeFunctionalities) {
		this.privatePracticeFunctionalities = privatePracticeFunctionalities;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(hash);
		sb.append("|");
		sb.append(active);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}