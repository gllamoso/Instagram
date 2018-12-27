package instagram.hashtag_search;

import org.openqa.selenium.By;

import instagram.PicSelected;
import selenium.Selenium;

public class HashtagSearch {
	private static PicSelected picSelected = new PicSelected();
	private Selectors selectors = new Selectors();
	//---------------------------------------------------------------------------------------------
	public PicSelected picSelected(){
		return picSelected;
	}
	//---------------------------------------------------------------------------------------------
	public void clickPic(int index){
		Selenium.click(selectors.pic(index), "picture #" + index);
		Selenium.waitForSelector(selectors.picDialogBox());
		picSelected.setUsername(Selenium.fetchText(selectors.userButton()));
	}
	//---------------------------------------------------------------------------------------------
	//=============================================================================================
	private class Selectors{
		public By pic(int index){ return By.xpath("(//a)[" + index + "]"); }
		public By picDialogBox(){ return By.xpath("//div[@role='dialog']"); }
		public By userButton(){ return By.xpath("(//div[@role='dialog']//h2/a)[1]"); }
	}
	//=============================================================================================
}
