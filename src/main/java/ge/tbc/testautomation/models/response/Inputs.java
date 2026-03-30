package ge.tbc.testautomation.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Inputs(
        String title,
        String bodyText,
        String body,

        List<Button> buttons,
        Button button,

        List<Slide> slides,
        List<Card> cards,

        List<ListItem> list
) {
}
