package com.github.webdriverextensions.generator;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.assertIsOpen;
import static com.github.webdriverextensions.Bot.click;
import static com.github.webdriverextensions.Bot.open;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.model.WebDriverExtensionSite;
import com.github.webdriverextensions.model.pages.ExamplesPage;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(WebDriverRunner.class)
@Chrome
public class WebRepositoryGeneratorTest {

    public final String url = "file://" + getClass().getResource("/html/model-test.html").getPath();

    WebDriverExtensionSite webDriverExtensionSite;
    ExamplesPage examplesPage;
    
    @Test
    public void webSiteTest() {
        open(webDriverExtensionSite.url);
        assertIsOpen(webDriverExtensionSite);
    }

    @Test
    public void webPageTest() {
        open(webDriverExtensionSite.examplesPage);
        assertIsOpen(webDriverExtensionSite.examplesPage);
    }

    @Test
    public void webRepositoryTest() {
        open(examplesPage.);
        assertIsOpen(webDriverExtensionRepository.examplesPage);
    }
    
    @Test
    public void webComponentTest() {
        open(url);
        click(menu);
        assertIsDisplayed(menu.create);
        assertIsDisplayed(menu.update);
        assertIsDisplayed(menu.delete);
    }

}
