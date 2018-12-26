package instagram;

import org.openqa.selenium.By;

import instagram.tagged_search.HashtagSearch;
import selenium.Selenium;
import selenium.Selenium.Browser;

public class Instagram {
	private static HashtagSearch hashtagSearch = new HashtagSearch();
	//---------------------------------------------------------------------------------------------
	public static HashtagSearch hashtagSearch(){
		return hashtagSearch;
	}
	//---------------------------------------------------------------------------------------------
	public static void start(Browser browser){
		Selenium.setup(Browser.Chrome);
		Selenium.navigate("https://www.instagram.com/accounts/login/?source=auth_switcher");
		Selenium.getDriver().manage().window().maximize();
	}
	//---------------------------------------------------------------------------------------------
	public static void login(String username, String password){
		Selenium.set(Selectors.username(), username);
		Selenium.set(Selectors.password(), password);
		Selenium.click(Selectors.login());
		if(Selenium.exists(Selectors.loginErrorAlert())){
			System.out.println("Error logging in: " + Selenium.fetchText(Selectors.loginErrorAlert()));
			Selenium.stop();
		}
		else{
			System.out.println("Successfully logged in: " + username);
		}
	}
	//---------------------------------------------------------------------------------------------
	public static void dismissNotificationsPopup(){
		if(Selenium.exists(Selectors.dialogBox())){
			String dialogText = Selenium.fetchText(Selectors.dialogHeader());
			Selenium.click(Selectors.notNowButton());
			System.out.println(dialogText + ": Not Now");
		}
	}
	//---------------------------------------------------------------------------------------------
	public static void search(String input){
		Selenium.set(Selectors.searchBar(), input);
		Selenium.wait(2);
		String firstSearchResult = Selenium.fetchText(Selectors.searchResultName(1));
		Selenium.click(Selectors.searchResult(1));
		System.out.println("Search: " + input);
		System.out.println("Clicked on first search result: " + firstSearchResult);
		Selenium.wait(5);
	}
	//---------------------------------------------------------------------------------------------
	
	//=============================================================================================
	public static class Selectors{
		// Login Page
		public static By username(){ return By.xpath("//input[@name='username']"); }
		public static By password(){ return By.xpath("//input[@name='password']"); }
		public static By login(){ return By.xpath("//button[text()='Log in']"); }
		public static By loginErrorAlert() { return By.xpath("//p[@id='slfErrorAlert']"); }
		
		// Dialog Box
		public static By dialogBox(){ return By.xpath("//div[@role='dialog']"); }
		public static By dialogHeader(){ return By.xpath("//div[@role='dialog']//h2"); }
		public static By notNowButton(){ return By.xpath("//button[text()='Not Now']"); }
		
		// Search
		public static By searchBar(){ return By.xpath("//input[@placeholder='Search']"); }
		public static By searchResult(int index){ return By.xpath("//input[@placeholder='Search']/following-sibling::div//a[" + index + "]"); }
		public static By searchResultName(int index){ return By.xpath("(//input[@placeholder='Search']/following-sibling::div//a[" + index + "]//span)[2]"); }
		
	}
	//=============================================================================================
}