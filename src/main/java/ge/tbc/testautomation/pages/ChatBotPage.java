package ge.tbc.testautomation.pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ChatBotPage {

    private final Page page;

    public FrameLocator chatboxIframe;
    public Locator chat, sendMessage, chatboxMessages, messageLoading;

    public ChatBotPage(Page page) {
        this.page = page;
        this.chatboxIframe = page.frameLocator("//iframe[@name='Messaging window']");
        this.chat = chatboxIframe.locator("//textarea[@id='composer-input']");
        this.sendMessage = chatboxIframe.locator("//button[@aria-label='Send message']");
        this.chatboxMessages = chatboxIframe.locator("//figure[@data-garden-id='avatars.avatar']//following-sibling::div//span[@tabindex='-1']");
        this.messageLoading = chatboxIframe.locator("//svg[@aria-label='loading']");
    }
}