package scripts;

import selenium.Selenium;
import selenium.Selenium.Browser;
import instagram.Instagram;
import instagram.hashtag_search.HashtagSearch;

public class UnitTest {
	
	public static void main(String[] args){
		
		Instagram.start(Browser.Chrome);
		Instagram.login("hello@surilis.com", "Gorillasvsbears123!");
		Instagram.dismissNotificationsPopup();
		Instagram.search("#travel");
		
		Instagram.hashtagSearch().clickPic(2);
		Selenium.wait(3);
		Instagram.hashtagSearch().picSelected().clickLike();
		Selenium.wait(3);
		Instagram.hashtagSearch().picSelected().clickUnlike();
		Selenium.wait(3);
		Instagram.hashtagSearch().picSelected().clickFollow();
		Selenium.wait(3);
		Instagram.hashtagSearch().picSelected().unfollow();
		
//		Selenium.stop();
	}
}
