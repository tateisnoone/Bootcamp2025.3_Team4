package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.testautomation.pages.ChatBotPage;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ChatBotSteps {

    private final ChatBotPage chatBotPage;

    public ChatBotSteps(Page page) {
        this.chatBotPage = new ChatBotPage(page);
    }

    @Step("Type message in chatbot input: '{message}'")
    public ChatBotSteps writeMessage(String message) {
        chatBotPage.chat.fill(message);
        return this;
    }

    @Step("Click send button to submit message")
    public ChatBotSteps clickSendButton() {
        chatBotPage.sendMessage.click();
        return this;
    }

    @Step("Wait for chatbot response to finish loading")
    public ChatBotSteps waitForChatBoxMessageToLoad() {
        chatBotPage.messageLoading.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.HIDDEN)
                .setTimeout(30000));
        return this;
    }

    @Step("Verify chatbot response message is visible")
    public ChatBotSteps validateChatBox() {
        assertThat(chatBotPage.chatboxMessages.first()).isVisible();
        return this;
    }
}