package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;



public class Report {

		
	public static void generateJvmReport(String jsonReportFile) {
		File file = new File("C:\\eclipse\\CucumberProject\\target");
		Configuration configuration = new Configuration(file, jsonReportFile);
		configuration.addClassifications("Browser", "Chrome");
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonReportFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();
		
			
		}}


