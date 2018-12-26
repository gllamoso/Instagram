package instagram.hashtag_search;

import org.openqa.selenium.By;

import instagram.PicSelected;
import selenium.Selenium;

public class HashtagSearch {
	private static PicSelected picSelected = new PicSelected();
	//---------------------------------------------------------------------------------------------
	public PicSelected picSelected(){
		return picSelected;
	}
	//---------------------------------------------------------------------------------------------
	public void clickPic(int index){
		Selenium.click(Selectors.pic(index));
		Selenium.waitForSelector(Selectors.picDialogBox());
		System.out.println("Picture #" + index + " clicked");
		picSelected.setUsername("@" + Selenium.fetchText(Selectors.userButton()));
	}
	//---------------------------------------------------------------------------------------------
	//=============================================================================================
	public static class Selectors{
		public static By pic(int index){ return By.xpath("(//a)[" + index + "]"); }
		public static By picDialogBox(){ return By.xpath("//div[@role='dialog']"); }
		public static By userButton(){ return By.xpath("(//div[@role='dialog']//h2/a)[1]"); }
	}
	//=============================================================================================
}
