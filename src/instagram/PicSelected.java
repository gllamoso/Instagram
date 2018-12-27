package instagram;

import org.openqa.selenium.By;

import selenium.Selenium;

public class PicSelected {
	private Selectors selectors = new Selectors();
	private String profileName;
	
	//---------------------------------------------------------------------------------------------
	public Selectors selectors(){
		return selectors;
	}
	//---------------------------------------------------------------------------------------------
	public void setUsername(String profileName){
		this.profileName = profileName;
	}
	//---------------------------------------------------------------------------------------------
	public void clickLike(){
		Selenium.click(selectors.likeButton());
		Selenium.result("Liked picture of " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void clickUnlike(){
		Selenium.click(selectors.unlikeButton());
		Selenium.result("Unliked picture of " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void clickFollow(){
		Selenium.click(selectors.followButton());
		Selenium.result("Followed " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void clickClose(){
		Selenium.click(selectors.closeButton());
		Selenium.result("Closed picture of " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	public void unfollow(){
		Selenium.click(selectors.followingButton());
		Selenium.waitForSelector(selectors.unfollowButton());
		Selenium.click(selectors.unfollowButton());
		Selenium.result("Unfollowed " + profileName);
	}
	//---------------------------------------------------------------------------------------------
	//=============================================================================================
	public class Selectors{
		public By likeButton(){ return By.xpath("//span[@aria-label='Like']/parent::button[contains(@class,'SpriteHeart')]"); }
		public By unlikeButton(){ return By.xpath("//span[@aria-label='Unlike']/parent::button[contains(@class,'SpriteHeart')]"); }
		public By followButton(){ return By.xpath("//div[@role='dialog']//button[text()='Follow']"); }
		public By followingButton(){ return By.xpath("//div[@role='dialog']//button[text()='Following']"); }
		public By unfollowButton(){ return By.xpath("//div[@role='dialog']//button[text()='Unfollow']"); }
		public By closeButton(){ return By.xpath("//button[text()='Close']"); }
		public By userButton(){ return By.xpath("(//div[@role='dialog']//h2/a)[1]"); }
	}
	//=============================================================================================
}
