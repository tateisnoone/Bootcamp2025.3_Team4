package ge.tbc.testautomation;

public class Constants {
    public static final String BASE_URL = "https://tbcbank.ge/";
    // Common
    public static final String MOBILE = "mobile";
    public static final String HEADER_TXT = "header";
    public static final String FOR_ME_TXT = "ჩემთვის";
    public static final String REQUEST = "Request";
    public static final String RESPONSE = "Response";
    public static final String CARDS_TXT = "ბარათები";

    // api
    public static final String COMPONENTS_NULL_ERROR = "Section components should not be null";
    public static final String SECTION_COMPONENTS_NOT_NULL = "Section components should not be null";
    public static final String SECTION_NOT_FOUND = "Section not found: ";
    public static final String CTA_TITLE_MISMATCH = "CTA title mismatch";
    public static final String CTA_BUTTON_MISMATCH = "CTA button mismatch";
    public static final String CTA_LIST_MISMATCH = "CTA list mismatch";
    public static final String CARDS_MISMATCH = "Cards mismatch";
    public static final String OLD_CARDS_MISMATCH = "Old cards mismatch";
    public static final String BANNER_MISMATCH = "Banner mismatch";

    public static final String CTA_SECTION = "ctaSection";
    public static final String CARDS_GRID_CAROUSEL = "cardsGridCarousel";
    public static final String CARDS_CAROUSEL = "cardsCarousel";
    public static final String ICON_BANNER ="iconBannerSection";

    public static final String VALID_PAGE_ID = "42QIbP7GGWzmhrXpSV3iA4";
    public static final String BASE_URI = "https://apigw.tbcbank.ge";
    public static final String BASE_PATH = "/api/v1/sites/pages/{pageId}";
    public static final String PATH_PARAM_PAGE_ID = "pageId";
    public static final String LOCALE = "locale";
    public static final String GEO_KA = "ka-GE";

    //cards page

    public static final String OTHER_CARDS = "სხვა ბარათები";
    public static final String LOYAL_CARD = "ერთგული საკრედიტო ბარათი";
    public static final String STUDENTS_CARD = "თიბისი ბარათი სტუდენტებისთვის";
    public static final String PUPILS_CARD = "მოსწავლის ბარათი";
    public static final String OLD_CARDS = "ძველი ბარათები";
    public static final String CARD_SAFETY_SERVICES = "ბარათის უსაფრთხოების სერვისი";
    public static final String QR_CODE_DATA = "https://app.tbcbank.ge/YiId/vdigxphg";

    // Ertguli Credit Card page

    public static final String ORDER_CARD_TXT= "შეუკვეთე ბარათი";
    public static final String NAME_AND_SURNAME_TXT = "სახელი და გვარი";
    public static final String PERSONAL_NUMBER_TXT = "პირადი ნომერი";
    public static final String PHONE_NUMBER_TXT = "ტელეფონის ნომერი";
    public static final String SUBMIT_BUTTON_TXT = "მოითხოვე ზარი";

    // Error Messages of Ertguli Credit Card Page Form
    public static final String ERROR_NAME_AND_SURNAME_TXT = "სახელი და გვარი ფორმატი არასწორია";
    public static final String ERROR_PERSONAL_NUMBER_TXT = "პირადი ნომერი ფორმატი არასწორია";
    public static final String ERROR_PHONE_NUMBER_TXT = "ტელეფონის ნომერი ფორმატი არასწორია";
    public static final String ERROR_PHONE_NUMBER_WHEN_FORMATTING_CHARACTERS_TXT = "ტელეფონის ნომერი ველი სავალდებულოა.";

    //DB
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DEVELOPMENT = "development";
    public static final String DB_URL =
            "jdbc:h2:mem:testdb;MODE=MSSQLServer;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE;DB_CLOSE_DELAY=-1";
    public static final String DB_USER = "sa";
 }
