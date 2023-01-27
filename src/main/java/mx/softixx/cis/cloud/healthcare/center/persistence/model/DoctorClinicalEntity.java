package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "doctor_clinical_entity"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "doctor_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_clinical_entity_id_seq", allocationSize = 1)
public class DoctorClinicalEntity extends BaseEntity {

	@Column(name = "doctor_id")
	private Long doctorId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
    private ClinicalEntity clinicalEntity;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntity", targetEntity = AssistantDoctorClinicalEntity.class)
	private List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntity", targetEntity = DoctorClinicalEntitySpeciality.class)
	private List<DoctorClinicalEntitySpeciality> doctorClinicalEntitySpecialities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntity", targetEntity = NurseDoctorClinicalEntity.class)
	private List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities;

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AssistantDoctorClinicalEntity> getAssistantDoctorClinicalEntities() {
		if (assistantDoctorClinicalEntities == null) {
			assistantDoctorClinicalEntities = new ArrayList<>();
		}
		return assistantDoctorClinicalEntities;
	}

	public void setAssistantDoctorClinicalEntities(
			List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities) {
		this.assistantDoctorClinicalEntities = assistantDoctorClinicalEntities;
	}

	public List<DoctorClinicalEntitySpeciality> getDoctorClinicalEntitySpecialities() {
		if (doctorClinicalEntitySpecialities == null) {
			doctorClinicalEntitySpecialities = new ArrayList<>();
		}
		return doctorClinicalEntitySpecialities;
	}

	public void setDoctorClinicalEntitySpecialities(
			List<DoctorClinicalEntitySpeciality> doctorClinicalEntitySpecialities) {
		this.doctorClinicalEntitySpecialities = doctorClinicalEntitySpecialities;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public List<NurseDoctorClinicalEntity> getNurseDoctorClinicalEntities() {
		if (nurseDoctorClinicalEntities == null) {
			nurseDoctorClinicalEntities = new ArrayList<>();
		}
		return nurseDoctorClinicalEntities;
	}

	public void setNurseDoctorClinicalEntities(List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities) {
		this.nurseDoctorClinicalEntities = nurseDoctorClinicalEntities;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(active);
		return sb.toString();
	}

}