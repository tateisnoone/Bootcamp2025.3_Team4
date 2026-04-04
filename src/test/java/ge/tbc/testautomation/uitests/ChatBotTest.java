package ge.tbc.testautomation.uitests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.Chatbot_message;

public class ChatBotTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void chatBotTest() {
        utils.bottomScroll();

        mainSteps.clickChatBot();

        chatBotSteps
                .writeMessage(Chatbot_message)
                .clickSendButton()
                .waitForChatBoxMessageToLoad()
                .validateChatBox();
    }
}