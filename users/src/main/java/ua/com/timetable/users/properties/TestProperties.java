package ua.com.timetable.users.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("test")
public class TestProperties {
	
	private String conn;
	
	private String holt;
	
	private int port;
	
	private boolean test;

	public TestProperties() {
		super();
	}

	public String getConn() {
		return conn;
	}

	public void setConn(String conn) {
		this.conn = conn;
	}

	public String getHolt() {
		return holt;
	}

	public void setHolt(String holt) {
		this.holt = holt;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	
	

}
