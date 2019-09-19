package com.erp.model;

import org.springframework.stereotype.Component;

@Component("log4")
public class Log4 {
    private String log_name;
    private String log_pass;
    private String log_time;
    private String log_IP;
    private int log_status;
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	public String getLog_pass() {
		return log_pass;
	}
	public void setLog_pass(String log_pass) {
		this.log_pass = log_pass;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	public String getLog_IP() {
		return log_IP;
	}
	public void setLog_IP(String log_IP) {
		this.log_IP = log_IP;
	}
	public int getLog_status() {
		return log_status;
	}
	public void setLog_status(int log_status) {
		this.log_status = log_status;
	}
}
