package io.pivotal.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJpaRepositories("io.pivotal.repository")
public class SimpleController {
	
	DBInfo dbInfo;
	public SimpleController(DBInfo dbInfo) {
		this.dbInfo=dbInfo;
	}
	
	@RequestMapping("/dbinfo")
	public DBInfo getInfo() {
		return this.dbInfo;
	}

}

@Component
class DBInfo{
	
	private String url;
	
	public DBInfo(DataSource datasource) throws SQLException{
		
		this.url=datasource.getConnection().getMetaData().getURL();
		
	}
	
	public String getUrl() {
		return url;
	}
}

