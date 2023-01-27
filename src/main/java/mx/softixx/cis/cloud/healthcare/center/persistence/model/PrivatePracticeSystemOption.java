package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "private_practice_system_option"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "private_practice_system_option", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_system_option_id_seq", allocationSize = 1)
public class PrivatePracticeSystemOption extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@Column(name = "auto_config_system_option_id")
	private Long autoConfigSystemOptionId;

	@Column(name = "hash", nullable = false, length = 50)
	private String hash;

	@Column(name = "active")
	private boolean active;

	public PrivatePracticeSystemOption() {
	}

	public PrivatePracticeSystemOption(PrivatePractice privatePractice, Long autoConfigSystemOptionId) {
		this.privatePractice = privatePractice;
		this.autoConfigSystemOptionId = autoConfigSystemOptionId;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = true;
	}

	/* Getters and Setters */
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

	public Long getAutoConfigSystemOptionId() {
		return autoConfigSystemOptionId;
	}

	public void setAutoConfigSystemOptionId(Long autoConfigSystemOptionId) {
		this.autoConfigSystemOptionId = autoConfigSystemOptionId;
	}

	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
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
		return sb.toString();
	}

}