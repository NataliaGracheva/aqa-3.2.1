package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    public DashboardPage() {
//        heading.shouldHave(text("Личный кабинет"));
        heading.shouldBe(visible);
    }

    public String getHeading() {
        return heading.getText().trim();
    }
}
