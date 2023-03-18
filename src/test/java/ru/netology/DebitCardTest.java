package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class DebitCardTest {


    @Test
    void shouldTest(){
        open("http://localhost:9999");
        $("span[data-test-id=name] input").setValue("Генадий");
        $("span[data-test-id=phone] input").setValue("+79057359359");
        $("[data-test-id=agreement]").click();
        $(By.className("button__text")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.")).getText();

    }
}
