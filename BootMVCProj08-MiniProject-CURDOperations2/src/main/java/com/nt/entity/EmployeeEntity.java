//EmployeeEntity.java
package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="JPA_MP_EMPLOYEE")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeEntity {
	//Data Properties
	@Id
	@SequenceGenerator(name="gen1",initialValue = 100, allocationSize = 1,sequenceName = "EMPNO_SEQ")
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length = 30)
	@NonNull
	private  String ename;

	@NonNull
	@Column(length = 30)
	private  String  eaddrs;
	
	@Column(length = 30)
	@NonNull
	private  String desg;
	@NonNull
	private  Double salary;
	
	//MetaData Properties
	@Version
	private  Integer  updateCount;
	
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private  LocalDateTime  creationTime;
	
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private  LocalDateTime  updationTime;
	
	@Column(length = 30)
	private  String createdBy;
	@Column(length = 30)
	private  String updatedBy;
	@Column(length = 30)
	private  String active_SW="active";

}
