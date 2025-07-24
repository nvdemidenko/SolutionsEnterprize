import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprize {
    @BeforeAll
    static void browserSetUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void solutionsEnterprizeTest() {
        open();
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform"));
    }


}

