package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "private_practice_service"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "private_practice_service", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_service_id_seq", allocationSize = 1)
public class PrivatePracticeService extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@Column(name = "doctor_speciality_id")
	private Long doctorSpecialityId;

	@Column(name = "code", nullable = false, length = 10)
	private String code;

	@Column(name = "description", nullable = false, length = 500)
	private String description;

	@Column(name = "subtotal")
	private BigDecimal subtotal;

	@Column(name = "tax")
	private BigDecimal tax;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "discount_start_date")
	private LocalDateTime discountStartDate;

	@Column(name = "discount_due_date")
	private LocalDateTime discountDueDate;

	@Column(name = "active")
	private boolean active;

	public PrivatePracticeService() {
	}

	public PrivatePracticeService(PrivatePractice privatePractice, Long doctorSpecialityId, String code,
			String description, BigDecimal subtotal, BigDecimal total) {
		this.privatePractice = privatePractice;
		this.doctorSpecialityId = doctorSpecialityId;
		this.code = code;
		this.description = description;
		this.subtotal = subtotal;
		this.total = total;
		this.active = true;
	}

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDateTime getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(LocalDateTime discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

	public LocalDateTime getDiscountDueDate() {
		return discountDueDate;
	}

	public void setDiscountDueDate(LocalDateTime discountDueDate) {
		this.discountDueDate = discountDueDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
	}

	public Long getDoctorSpecialityId() {
		return doctorSpecialityId;
	}

	public void setDoctorSpecialityId(Long doctorSpecialityId) {
		this.doctorSpecialityId = doctorSpecialityId;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(code);
		sb.append("|");
		sb.append(description);
		sb.append("|");
		sb.append(subtotal);
		sb.append("|");
		sb.append(tax);
		sb.append("|");
		sb.append(discount);
		sb.append("|");
		sb.append(total);
		sb.append("|");
		sb.append(discountStartDate);
		sb.append("|");
		sb.append(discountDueDate);
		sb.append("|");
		sb.append(active);
		return sb.toString();
	}

}