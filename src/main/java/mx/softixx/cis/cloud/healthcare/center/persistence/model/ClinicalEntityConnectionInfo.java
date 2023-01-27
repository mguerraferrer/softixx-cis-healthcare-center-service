package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "clinical_entity_connection_info"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_connection_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_connection_info_id_seq", allocationSize = 1)
public class ClinicalEntityConnectionInfo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_access_info_id", referencedColumnName = "id")
	private ClinicalEntityAccessInfo clinicalEntityAccessInfo;

	@Column(name = "ip", length = 20)
	private String ip;

	@Column(name = "ip_range_start", length = 20)
	private String ipRangeStart;

	@Column(name = "ip_range_end", length = 20)
	private String ipRangeEnd;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpRangeStart() {
		return ipRangeStart;
	}

	public void setIpRangeStart(String ipRangeStart) {
		this.ipRangeStart = ipRangeStart;
	}

	public String getIpRangeEnd() {
		return ipRangeEnd;
	}

	public void setIpRangeEnd(String ipRangeEnd) {
		this.ipRangeEnd = ipRangeEnd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ClinicalEntityAccessInfo getClinicalEntityAccessInfo() {
		return clinicalEntityAccessInfo;
	}

	public void setClinicalEntityAccessInfo(ClinicalEntityAccessInfo clinicalEntityAccessInfo) {
		this.clinicalEntityAccessInfo = clinicalEntityAccessInfo;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(ip);
		sb.append("|");
		sb.append(ipRangeStart);
		sb.append("|");
		sb.append(ipRangeEnd);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}