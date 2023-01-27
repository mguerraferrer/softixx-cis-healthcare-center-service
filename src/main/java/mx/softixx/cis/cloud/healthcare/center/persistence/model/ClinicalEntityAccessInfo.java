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
 * Persistent class for entity stored in table "clinical_entity_access_info"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_access_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_access_info_id_seq", allocationSize = 1)
public class ClinicalEntityAccessInfo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@Column(name = "profile_id")
	private Long profileId;

	@Column(name = "access_level_id")
	private Long accessLevelId;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clinicalEntityAccessInfo", targetEntity = ClinicalEntityEmploymentInfo.class)
	private List<ClinicalEntityEmploymentInfo> clinicalEntityEmploymentInfos;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clinicalEntityAccessInfo", targetEntity = ClinicalEntityConnectionInfo.class)
	private List<ClinicalEntityConnectionInfo> clinicalEntityConnectionInfos;

	/* Getters and Setters */
	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getAccessLevelId() {
		return accessLevelId;
	}

	public void setAccessLevelId(Long accessLevelId) {
		this.accessLevelId = accessLevelId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ClinicalEntityEmploymentInfo> getClinicalEntityEmploymentInfos() {
		if (clinicalEntityEmploymentInfos == null) {
			clinicalEntityEmploymentInfos = new ArrayList<>();
		}
		return clinicalEntityEmploymentInfos;
	}

	public void setClinicalEntityEmploymentInfos(
			List<ClinicalEntityEmploymentInfo> clinicalEntityEmploymentInfos) {
		this.clinicalEntityEmploymentInfos = clinicalEntityEmploymentInfos;
	}

	public List<ClinicalEntityConnectionInfo> getClinicalEntityConnectionInfos() {
		if (clinicalEntityConnectionInfos == null) {
			clinicalEntityConnectionInfos = new ArrayList<>();
		}
		return clinicalEntityConnectionInfos;
	}

	public void setClinicalEntityConnectionInfos(
			List<ClinicalEntityConnectionInfo> clinicalEntityConnectionInfos) {
		this.clinicalEntityConnectionInfos = clinicalEntityConnectionInfos;
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