package scripts;

import selenium.Selenium;
import selenium.Selenium.Browser;

import java.util.Arrays;
import java.util.Collections;

import instagram.Instagram;

public class LikeAndFollow {
	
	private static final int NUMBER_OF_PICS = 40;
	private static final int MIN_WAIT_TIME = 2;
	private static final int MAX_WAIT_TIME = 8;
	
	public static void main(String[] args){
		
		Integer[] arr = new Integer[NUMBER_OF_PICS];
		for (int i = 0; i < arr.length; i++) {
	        arr[i] = i + 1;
	    }
		Collections.shuffle(Arrays.asList(arr));
		
		Instagram.start(Browser.Chrome);
		Instagram.login("hello@surilis.com", "Gorillasvsbears123!");
		Instagram.dismissNotificationsPopup();
		Instagram.search("#travel");
		
		for(int i = 0; i < arr.length; i++){
			Selenium.randomizedWait(MIN_WAIT_TIME, MAX_WAIT_TIME);
			Instagram.hashtagSearch().clickPic(arr[i]);
			Selenium.randomizedWait(MIN_WAIT_TIME, MAX_WAIT_TIME);
			Instagram.hashtagSearch().picSelected().clickLike();
			Selenium.randomizedWait(MIN_WAIT_TIME, MAX_WAIT_TIME);
			Instagram.hashtagSearch().picSelected().clickUnlike();
			Selenium.randomizedWait(MIN_WAIT_TIME, MAX_WAIT_TIME);
			Instagram.hashtagSearch().picSelected().clickFollow();
			Selenium.randomizedWait(MIN_WAIT_TIME, MAX_WAIT_TIME);
			Instagram.hashtagSearch().picSelected().unfollow();
			Selenium.randomizedWait(MIN_WAIT_TIME, MAX_WAIT_TIME);
			Instagram.hashtagSearch().picSelected().clickClose();
		}
		
		Selenium.stop("PASSED: Unit Test");
	}
}