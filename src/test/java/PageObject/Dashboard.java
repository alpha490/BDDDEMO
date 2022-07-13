package PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver ldriver;

	public Dashboard(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(xpath = "//div[@class='card-title'][normalize-space()='Common statistics']")
	WebElement commonstatics;
	
	@FindBy(xpath="//div[@id='nopcommerce-common-statistics-card']//div[@class='card-body']")
	WebElement tiles;

	@FindBy(xpath = "//div[@id='nopcommerce-common-statistics-card']//button[@type='button']")
	WebElement expandbtn;
	
	@FindBy(xpath = "//h3[normalize-space()='Orders']")
	WebElement orderdashboard;
	
	@FindBy(xpath="//canvas[@id='order-statistics-chart']")
	WebElement ordergraph;

	@FindBy(xpath = "//div[@id='order-statistics-card']//button[@type='button']")
	WebElement expandbtnorders;
	
	@FindBy(xpath = "//div[@id='order-incomplete-report-card']//i[@class='fas fa-plus']")
	WebElement expandbtnincompleteorder;
	
	@FindBy(xpath = "//h3[normalize-space()='Incomplete orders']")
	WebElement incompleteorderdashboard;
	
	
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	

	
	public void verifystaticsoption()
	{
		String actual = commonstatics.getText();
		String expected = "Common statistics";
		if (actual.contains(expected) )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	public void verifystaticstiles()
	{
	expandbtn.click();	
		
	if (tiles.isDisplayed())
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	}
	
	public void verifyorderoption()
	{
		String actual = orderdashboard.getText();
		String expected = "Orders";
		if (actual.contains(expected) )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	public void verifyordergraph()
	{
		expandbtnorders.click();	
		
	if (ordergraph.isDisplayed())
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	}

	
	public void verifyincompleteorderoption()
	{
		String actual = incompleteorderdashboard.getText();
		String expected = "Incomplete orders";
		if (actual.contains(expected) )
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	public void Totalincompleteordervalue()
	{
		expandbtnincompleteorder.click();
		List<WebElement> elements = ldriver.findElements(By.xpath("//div[@id='order-incomplete-report-card']//div[@class='card-body']//tr//td[contains(text(),'$')]"));
		float od = 0;
		for (WebElement element : elements){
		     
			String ordervalue = element.getText();
			ordervalue = ordervalue.substring(1);
			float i=Float.parseFloat(ordervalue);
		    od = od+i;
		    }
		System.out.println(od);  
	
	}
}
