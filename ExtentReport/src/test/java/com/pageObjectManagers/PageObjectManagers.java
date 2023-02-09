package com.pageObjectManagers;

import com.pages.LoginPage;

public class PageObjectManagers {
private LoginPage loginPage;

public LoginPage getLoginPage() {
	
	return (loginPage==null)?loginPage=new LoginPage():loginPage;
}




}
