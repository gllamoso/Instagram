package instagram;

import org.openqa.selenium.By;

import instagram.hashtag_search.HashtagSearch;
import selenium.Selenium;
import selenium.Selenium.Browser;

public class Instagram {
	private static HashtagSearch hashtagSearch = new HashtagSearch();
	private static Selectors selectors = new Selectors();
	//---------------------------------------------------------------------------------------------
	public static HashtagSearch hashtagSearch(){
		return hashtagSearch;
	}
	//---------------------------------------------------------------------------------------------
	public static Selectors selectors(){
		return selectors;
	}
	//---------------------------------------------------------------------------------------------
	public static void start(Browser browser){
		Selenium.setup(Browser.Chrome);
		Selenium.navigate("https://www.instagram.com/accounts/login/?source=auth_switcher");
		Selenium.getDriver().manage().window().maximize();
	}
	//---------------------------------------------------------------------------------------------
	public static void login(String username, String password){
		Selenium.set(selectors.username(), username);
		Selenium.set(selectors.password(), password);
		Selenium.click(selectors.login());
		if(Selenium.exists(selectors.loginErrorAlert())){
			Selenium.stop("FAILURE: Unable to log in: " + Selenium.fetchText(selectors.loginErrorAlert()));
		}
		else{
			Selenium.result("Logged in as " + username);
		}
	}
	//---------------------------------------------------------------------------------------------
	public static void dismissNotificationsPopup(){
		if(Selenium.exists(selectors.dialogBox())){
			String dialogText = Selenium.fetchText(selectors.dialogHeader());
			Selenium.click(selectors.notNowButton());
			Selenium.result(dialogText + ": Not Now");
		}
		else{
			Selenium.log("No popup found");
		}
	}
	//---------------------------------------------------------------------------------------------
	public static void search(String input){
		Selenium.set(selectors.searchBar(), input, "Search Bar");
		Selenium.wait(2);
		String firstSearchResult = Selenium.fetchText(selectors.searchResultName(1));
		Selenium.click(selectors.searchResult(1), "first search result: " + firstSearchResult);
		Selenium.wait(5);
	}
	//---------------------------------------------------------------------------------------------
	
	//=============================================================================================
	private static class Selectors{
		// Login Page
		public By username(){ return By.xpath("//input[@name='username']"); }
		public By password(){ return By.xpath("//input[@name='password']"); }
		public By login(){ return By.xpath("//button[string()='Log in']"); }
		public By loginErrorAlert() { return By.xpath("//p[@id='slfErrorAlert']"); }
		
		// Dialog Box
		public By dialogBox(){ return By.xpath("//div[@role='dialog']"); }
		public By dialogHeader(){ return By.xpath("//div[@role='dialog']//h2"); }
		public By notNowButton(){ return By.xpath("//button[text()='Not Now']"); }
		
		// Search
		public By searchBar(){ return By.xpath("//input[@placeholder='Search']"); }
		public By searchResult(int index){ return By.xpath("//input[@placeholder='Search']/following-sibling::div//a[" + index + "]"); }
		public By searchResultName(int index){ return By.xpath("(//input[@placeholder='Search']/following-sibling::div//a[" + index + "]//span)[2]"); }
		
	}
	//=============================================================================================
}
