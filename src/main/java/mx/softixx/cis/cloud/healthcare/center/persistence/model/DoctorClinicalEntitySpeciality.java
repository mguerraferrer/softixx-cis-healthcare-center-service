package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnTransformer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;
import mx.softixx.cis.common.jpa.util.ColumnTransformerUtil;

/**
 * Persistent class for entity stored in table
 * "doctor_clinical_entity_speciality"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "doctor_clinical_entity_speciality", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_clinical_entity_speciality_id_seq", allocationSize = 1)
public class DoctorClinicalEntitySpeciality extends BaseEntity {

	@Column(name = "speciality_id")
	private Long specialityId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_clinical_entity_id", referencedColumnName = "id")
	private DoctorClinicalEntity doctorClinicalEntity;

	@Column(name = "professional_license")
	@ColumnTransformer(read = "pgp_sym_decrypt(professional_license::bytea, '" + ColumnTransformerUtil.PGP_SYM_CRYPT_KEY
			+ "')", write = "pgp_sym_encrypt(?, '" + ColumnTransformerUtil.PGP_SYM_CRYPT_KEY + "')")
	private String professionalLicense;

	@Column(name = "appointment_duration")
	private Integer appointmentDuration;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntitySpeciality", targetEntity = DoctorClinicalEntityService.class)
	private List<DoctorClinicalEntityService> doctorClinicalEntityServices;

	public DoctorClinicalEntitySpeciality() {
	}

	public DoctorClinicalEntitySpeciality(DoctorClinicalEntity doctorClinicalEntity, Long specialityId,
			String professionalLicense, Integer appointmentDuration) {
		this.doctorClinicalEntity = doctorClinicalEntity;
		this.specialityId = specialityId;
		this.professionalLicense = professionalLicense;
		this.appointmentDuration = appointmentDuration;
		this.active = true;
	}

	/* Getters and Setters */
	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public Integer getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<DoctorClinicalEntityService> getDoctorClinicalEntityServices() {
		if (doctorClinicalEntityServices == null) {
			doctorClinicalEntityServices = new ArrayList<>();
		}
		return doctorClinicalEntityServices;
	}

	public void setDoctorClinicalEntityServices(List<DoctorClinicalEntityService> doctorClinicalEntityServices) {
		this.doctorClinicalEntityServices = doctorClinicalEntityServices;
	}

	public DoctorClinicalEntity getDoctorClinicalEntity() {
		return doctorClinicalEntity;
	}

	public void setDoctorClinicalEntity(DoctorClinicalEntity doctorClinicalEntity) {
		this.doctorClinicalEntity = doctorClinicalEntity;
	}

	public Long getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Long specialityId) {
		this.specialityId = specialityId;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(professionalLicense);
		sb.append("|");
		sb.append(appointmentDuration);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}