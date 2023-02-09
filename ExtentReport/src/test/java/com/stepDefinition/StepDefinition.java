package com.stepDefinition;

import com.base.BaseClass;
import com.pageObjectManagers.PageObjectManagers;

public class StepDefinition extends BaseClass {
PageObjectManagers pom = new PageObjectManagers();

public void login() {
	getDriver(1);
	loadUrl("https://app.flexifunnels.com/login");
	maximize();
	
}
}
