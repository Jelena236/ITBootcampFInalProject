package resources;

public class Constants {
	//Home page constants
	public static final String HOME_URL = "https://www.humanity.com/";
	
	//Close cookies and announcement
	public static final String CLOSEBTN_ANNO_CSS = "#tcp-modal > div > div > div.modal-header > button";
	public static final String ACC_COOKIESBTN_CSS = "#cf-root > div > div > div > div.cf2L3T.cfysV4.cf2mE1 > div.cf3Tgk.cf1IKf > div.cf1YU1.cfNq4w > button > span";
	public static final String CHAT_CLOSEBTN_XPATH = "//*[@id=\"intercom-container\"]/div/div/div[1]/div/div/span";
	
	//About Us page constants
	public static final String ABOUTUS_HEADER_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ABOUTUS_LINK_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]";
	public static final String ABOUTUS_URL = "https://www.humanity.com/about";
	
	public static final String HUMANITY_LOGO_XPATH = "//*[@id=\"_nav\"]/div[1]/img";
	
	//Login method constants
	public static final String LOGIN_LINK_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
	public static final String LOGIN_FORM_URL = "https://www.humanity.com/app/";
	public static final String USERNAMEFIELD_ID = "email";
	public static final String PASSWORDFIELD_ID = "password";
	public static final String LOGINBTN_NAME = "login";
	
	//Dashboard  constants
	public static final String USERSPAGE_URL = "https://jelenatester.humanity.com/app/dashboard/";
	public static final String DASHBOARDICON_XPATH = "//*[@id=\"sn_dashboard\"]/span/i";
	
	public static final String SHIFTPLANICON_XPATH = "//*[@id=\"sn_schedule\"]/span/i";
	public static final String SHIFTPLAN_TITLE = "ShiftPlanning - Humanity";
	public static final String AVAILICON_XPATH ="//*[@id=\"sn_availability\"]";
	public static final String AVAIL_TITLE = "Humanity";

	//Staff page constants
	public static final String STAFF_URL = "https://jelenatester.humanity.com/app/staff/list/load/true/";
	public static final String ADDEMPL_BTN_ID = "act_primary";
	public static final String ADDEMP_FORM_URL = "https://jelenatester.humanity.com/app/staff/add/";
	public static final String ADDEMP_FN_ID = "_asf1";
	public static final String ADDEMP_LN_ID = "_asl1";
	public static final String ADDEMP__EM_ID = "_ase1";
	public static final String SAVEEMP_ID = "_as_save_multiple";
	
	//Edit employee constants
	public static final String EMP1_LINK_XPATH = "//*[@id=\"7\"]/a";
	public static final String EMPEDIT_LINK_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String EDIT_FN_ID = "first_name";
	public static final String SAVECHANGE_NAME = "update";
	
	public static final String UPLOADP_BTN_ID = "in-btn";
	
	//Settings constants
	public static final String SETTINGS_URL = "https://jelenatester.humanity.com/app/admin/settings/";
	public static final String LANGUAGEDRP_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String SETT_SAVE_ID = "act_primary";
	
	public static final String NOTIF_EMAIL_ID = "pref_pref_email";
	public static final String NOTIF_SMS_ID = "pref_pref_sms";
	public static final String NOTIF_PUSH_ID = "pref_pref_mobile_push";
	
	//Profile constants
	public static final String PROFILE_BAR_CSS = "#wrap_us_menu > i";
	public static final String PROFILE_LINK_XPATH = "//*[@id=\"userm\"]/div/a[1]";
	public static final String EDITDETAILS_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String USERNAME_ID = "username";
	public static final String SAVE_BTN_CSS = "#act_primary";
	public static final String ADDPHOTO_ID = "fileupload";
	
	public static final String PAYROLL_LINK_XPATh = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[8]";
	public static final String RATE_FIELD_XPATH = "//*[@id=\"emp_pr\"]/table/tbody/tr[2]/td[3]/input";
	public static final String SAVE_RATE_XPATH = "//*[@id=\"emp_pr_update\"]";

	

 
}
