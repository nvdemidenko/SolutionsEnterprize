import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprise {
    @BeforeAll
    static void browserSetUp() {
        Configuration.pageLoadStrategy = "eager";
        baseUrl = "https://github.com";
    }

    @Test
    void solutionsEnterpriseTest() {
        open(baseUrl);
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform"));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement leftColumn = $("#column-a");
        SelenideElement rightColumn = $("#column-b");

        leftColumn.shouldHave(text("A"));
        rightColumn.shouldHave(text("B"));

        leftColumn.dragAndDrop(to(rightColumn));

        //заголовки поменялись местами
        leftColumn.shouldHave(text("B"));
        rightColumn.shouldHave(text("A"));
    }

    @Test
    void actionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement leftColumn = $("#column-a");
        SelenideElement rightColumn = $("#column-b");

        leftColumn.shouldHave(text("A"));
        rightColumn.shouldHave(text("B"));

        leftColumn.dragAndDrop(to(rightColumn));
        actions().clickAndHold(rightColumn).moveToElement(leftColumn).release();

        //заголовки поменялись местами
        leftColumn.shouldHave(text("B"));
        rightColumn.shouldHave(text("A"));
    }
}

