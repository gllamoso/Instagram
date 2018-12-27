package instagram;

import org.openqa.selenium.By;

import selenium.Selenium;

public class PicSelected {
	private String profileName;
	
	//---------------------------------------------------------------------------------------------
	public void setUsername(String profileName){
		this.profileName = profileName;
	}
	//---------------------------------------------------------------------------------------------
	public void clickLike(){
		Selenium.click(Selectors.likeButton());
		Selenium.result("Liked picture of " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void clickUnlike(){
		Selenium.click(Selectors.unlikeButton());
		Selenium.result("Unliked picture of " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void clickFollow(){
		Selenium.click(Selectors.followButton());
		Selenium.result("Followed " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void clickClose(){
		Selenium.click(Selectors.closeButton());
		Selenium.result("Closed picture of " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void unfollow(){
		Selenium.click(Selectors.followingButton());
		Selenium.waitForSelector(Selectors.unfollowButton());
		Selenium.click(Selectors.unfollowButton());
		Selenium.result("Unfollowed " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	//=============================================================================================
	public static class Selectors{
		public static By likeButton(){ return By.xpath("//span[@aria-label='Like']/parent::button[contains(@class,'SpriteHeart')]"); }
		public static By unlikeButton(){ return By.xpath("//span[@aria-label='Unlike']/parent::button[contains(@class,'SpriteHeart')]"); }
		public static By followButton(){ return By.xpath("//div[@role='dialog']//button[text()='Follow']"); }
		public static By followingButton(){ return By.xpath("//div[@role='dialog']//button[text()='Following']"); }
		public static By unfollowButton(){ return By.xpath("//div[@role='dialog']//button[text()='Unfollow']"); }
		public static By closeButton(){ return By.xpath("//button[text()='Close']"); }
		public static By userButton(){ return By.xpath("(//div[@role='dialog']//h2/a)[1]"); }
	}
	//=============================================================================================
}
