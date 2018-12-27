package scripts;

import selenium.Selenium;
import selenium.Selenium.Browser;
import instagram.Instagram;

public class UnitTest {
	
	public static void main(String[] args){
		
		Instagram.start(Browser.Chrome);
		Instagram.login("hello@surilis.com", "Gorillasvsbears123!");
		Instagram.dismissNotificationsPopup();
		Instagram.search("#travel");
		
		Instagram.hashtagSearch().clickPic(3);
		Selenium.wait(3);
		Instagram.hashtagSearch().picSelected().clickLike();
		Selenium.screenshotWhenElementIsVisible(Instagram.hashtagSearch().picSelected().selectors().unlikeButton(), "1. Like");
		Instagram.hashtagSearch().picSelected().clickUnlike();
		Instagram.hashtagSearch().picSelected().clickFollow();
		Selenium.screenshotWhenElementIsVisible(Instagram.hashtagSearch().picSelected().selectors().followingButton(), "2. Follow");
		Instagram.hashtagSearch().picSelected().unfollow();
		
		Selenium.screenshotWhenElementIsVisible(Instagram.hashtagSearch().picSelected().selectors().followButton(), "3. End");
		Selenium.stop("PASSED: Unit Test");
	}
}