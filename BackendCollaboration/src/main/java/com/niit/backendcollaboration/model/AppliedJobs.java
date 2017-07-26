package com.niit.backendcollaboration.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "appjobs")
public class AppliedJobs {   // one job how many applied admin as well as user should be able 2 view
	                            // varaibale first letter small 
	@Id
	@GeneratedValue	                                      // db config bean and dao pending
	private int ajId;
	
	
	private int  jobsid;
	private String jobname;
	private int userId;
	private String userName;
	
	private String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	
	/*
	@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date day = new java.sql.Date(new java.util.Date().getTime());
*/
	
	

	
	public int getAjId() {
		return ajId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void setAjId(int ajId) {
		this.ajId = ajId;
	}
	public int getJobsid() {
		return jobsid;
	}
	public void setJobsid(int jobsid) {
		this.jobsid = jobsid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	
	
	
}
