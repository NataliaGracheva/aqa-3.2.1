package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.mode.DbUtils;
import ru.netology.mode.User;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbInteraction {
    User user = new User("vasya", "qwerty123");

    @Test
    @DisplayName("Логин с валидными данными")
    void loginWithValidData() {
        open("http://localhost:9999");
        LoginPage loginPage = new LoginPage();
        VerificationPage verificationPage = loginPage.validLogin(user);
        DashboardPage dashboardPage = verificationPage.validVerify(DbUtils.getVerificationCode());
        assertEquals("Личный кабинет", dashboardPage.getHeading());
    }
}
