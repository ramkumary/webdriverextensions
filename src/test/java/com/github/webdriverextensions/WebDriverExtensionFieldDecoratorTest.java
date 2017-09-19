package com.github.webdriverextensions;

import static com.github.webdriverextensions.Bot.assertCurrentUrlEndsWith;
import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.assertSizeEquals;
import static com.github.webdriverextensions.Bot.assertTextEndsWith;
import static com.github.webdriverextensions.Bot.assertTextEquals;
import static com.github.webdriverextensions.Bot.click;
import static com.github.webdriverextensions.Bot.open;
import static com.github.webdriverextensions.Bot.type;
import static com.github.webdriverextensions.Bot.waitFor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import com.github.webdriverextensions.generator.WebRepositoryGenerator;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.model.components.UserRow;

@RunWith(WebDriverRunner.class)
@Chrome
public class WebDriverExtensionFieldDecoratorTest extends WebRepositoryGenerator {

    Double delayTime = 0.0;

    @Before
    public void before() {
        open(webDriverExtensionSite.url);
        open(examplesPage);
        assertCurrentUrlEndsWith("/model-test.html");
    }

    @Test
    public void webElementsTest() {
        type("What is WebDriver", examplesPage.searchQuery);
        waitFor(delayTime);
        click(examplesPage.search);
        assertSizeEquals(3, examplesPage.rows);
        assertSizeEquals(3, examplesPage.todos);
    }

    @Test
    public void extendedWebElementsTest() {
        click(examplesPage.menuButtonGroup.menu);
        waitFor(delayTime);
        assertIsDisplayed(examplesPage.menuButtonGroup.create);
        assertIsDisplayed(examplesPage.menuButtonGroup.update);
        assertIsDisplayed(examplesPage.menuButtonGroup.delete);
    }

    @Test
    public void listWithWebElementsTest() {
        waitFor(delayTime);
        for (WebElement todo : examplesPage.todos) {
            assertTextEndsWith("!", todo);
        }
        assertSizeEquals(3, examplesPage.todos);
    }

    @Test
    public void listWithExtendedWebElementsTest() {
        UserRow userRow = examplesPage.findUserRowByFirstName("Jacob");
        waitFor(delayTime);
        assertTextEquals("Thornton", userRow.lastName);
    }

    @Test
    public void resetSearchContextTest() {
        // Test Search Context ROOT with WebElement
        waitFor(delayTime);
        assertIsDisplayed(examplesPage.userTableSearchContext.searchQuery);
    }

    @Test
    public void resetSearchContextListTest() {
        waitFor(delayTime);
        assertSizeEquals(3, examplesPage.userTableSearchContext.todos);
    }

    @Test
    public void wrapperTest() {
        click(examplesPage.menu);
        waitFor(delayTime);
        assertIsDisplayed(examplesPage.menu.create);
        assertIsDisplayed(examplesPage.menu.update);
        assertIsDisplayed(examplesPage.menu.delete);
    }

    @Test
    public void doubleWrappedComponents() {
        click(examplesPage.body);
        click(examplesPage.body.menu);
        waitFor(delayTime);
        assertIsDisplayed(examplesPage.body.menu.create);
        assertIsDisplayed(examplesPage.body.menu.update);
        assertIsDisplayed(examplesPage.body.menu.delete);
    }
}
