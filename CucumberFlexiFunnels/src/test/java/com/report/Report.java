package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report {
public static void jvmreport(String reportfile) {
		
		File file = new File("C:\\Users\\Dell\\eclipse-workspace\\CucumberFlexiFunnels\\target");
		
		   Configuration config = new Configuration(file,"LOGIN");
		   config.addClassifications("Browser", "Chrome");
		
		    List<String>jsonfiles=new ArrayList<String>();
			jsonfiles.add(reportfile);
			
			ReportBuilder rb = new ReportBuilder(jsonfiles,config);
			rb.generateReports();
			
			
			
			
		}


}
