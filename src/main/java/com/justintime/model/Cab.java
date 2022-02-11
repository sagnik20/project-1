package com.justintime.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sagnik
 *
 */

@Entity
@Table(name = "cab")
public class Cab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false)
	private  Integer cabNo;
	@Column(nullable= false)
	private Integer status;
	@Column(nullable= false)
	private String	dName;
	@Column(nullable= false)
	private String dMobile;
	
	
	public Cab(Integer cabNo, Integer status, String dname, String dmobile) {
		this.cabNo = cabNo;
		this.status = status;
		this.dName = dname;
		this.dMobile = dmobile;
	}
	
	public Cab() {}




	/**
	 * @return the cabNo
	 */
	public Integer getCabNo() {
		return cabNo;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return the dName
	 */
	public String getdName() {
		return dName;
	}

	/**
	 * @return the dMobile
	 */
	public String getdMobile() {
		return dMobile;
	}

	/**
	 * @param cabNo the cabNo to set
	 */
	public void setCabNo(Integer cabNo) {
		this.cabNo = cabNo;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @param dName the dName to set
	 */
	public void setdName(String dName) {
		this.dName = dName;
	}

	/**
	 * @param dMobile the dMobile to set
	 */
	public void setdMobile(String dMobile) {
		this.dMobile = dMobile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cabNo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		return Objects.equals(cabNo, other.cabNo);
	}


	@Override
	public String toString() {
		return "Cab [Cab No=" + cabNo + ", Status=" + status
				+ ", Driver Name=" + dName + ", Driver Mobile no=" + dMobile + "]";
	}


	
	

}
