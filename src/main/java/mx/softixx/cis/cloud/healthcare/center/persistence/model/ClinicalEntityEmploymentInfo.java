package mx.softixx.cis.cloud.healthcare.center.persistence.model;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.softixx.cis.common.jpa.model.BaseEntity;

/**
 * Persistent class for entity stored in table "clinical_entity_employment_info"
 *
 * @author Maikel Guerra Ferrer - mguerraferrer@gmail.com
 *
 */

@Entity
@Table(name = "clinical_entity_employment_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_employment_info_id_seq", allocationSize = 1)
public class ClinicalEntityEmploymentInfo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_entity_access_info_id", referencedColumnName = "id")
    private ClinicalEntityAccessInfo clinicalEntityAccessInfo;
	
    @Column(name = "working_day", length = 10)
    private String workingDay;

    @Column(name = "working_days", length = 100)
    private String workingDays;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "active")
    private boolean active;

    /* Getters and Setters */
	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
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
        sb.append(workingDay);
        sb.append("|");
        sb.append(workingDays);
        sb.append("|");
        sb.append(startTime);
        sb.append("|");
        sb.append(endTime);
        sb.append("|");
        sb.append(active);
        return sb.toString();
    }

}