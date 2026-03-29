package ge.tbc.testautomation.utils;

import ge.tbc.testautomation.steps.CommonSteps;

import static ge.tbc.testautomation.Constants.MOBILE;

public class NavigationFlows {
    private final CommonSteps commonSteps;
    private final boolean mobile;

    public NavigationFlows(CommonSteps commonSteps, String view) {
        this.commonSteps = commonSteps;
        this.mobile = MOBILE.equalsIgnoreCase(view);
    }

    public void openCardsFromHome() {
        if (mobile) {
            commonSteps.openBurgerMenu();

            if (!commonSteps.isCardsBtnVisibleMobile()) {
                commonSteps.openCardsGroupMobile();
            }
            commonSteps.assertCardsLinkVisibleMobile()
                    .goToCardsFromCardsGroupMobile();
        } else {
            commonSteps.openForMe()
                    .goToCards();
        }
    }
}