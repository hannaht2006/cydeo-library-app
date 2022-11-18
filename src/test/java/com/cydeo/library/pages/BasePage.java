package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://library1.cydeo.com/#dashboard
public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[text() = 'Dashboard']")
    public WebElement dashboardLink;

    @FindBy(xpath = "//span[text() = 'Users']")
    public WebElement usersLink;

    @FindBy(xpath = "//*[text() = 'Books']")
    public WebElement booksLink;

    @FindBy(id = "navbarDropdown")
    public WebElement usernameLink;

    
   

    



}