package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.Report;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources"}, glue= "com.stepDefinition",plugin = {"json:target/reports/json/report.json"},dryRun=true)
public class TestRunner {
	@AfterClass
	public static void generateReport(){
//Report.jvmreport("C:\\Users\\Dell\\eclipse-workspace\\CucumberFlexiFunnels\\target\\reports\\json\\report.json");
		


	}
}
