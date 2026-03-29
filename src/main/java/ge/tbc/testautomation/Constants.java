package ge.tbc.testautomation;

public class Constants {
    public static final String BASE_URL = "https://tbcbank.ge/";
    // Common
    public static final String MOBILE = "mobile";
    public static final String HEADER_TXT = "header";
    public static final String FOR_ME_TXT = "ჩემთვის";
    public static final String MOBILE_BANK_TXT = "მობაილბანკი";
    public static final String EXCHANGE_RATE_TXT = "ვალუტის კურსები";
    public static final String LOCATIONS_TXT = "მისამართები";
    public static final String LOANS_TXT = "სესხები";
    public static final String DIGITAL_SERVICES_TXT = "ციფრული სერვისები";
    public static final String REQUEST = "Request";
    public static final String RESPONSE = "Response";
    public static final String BUT_GOT = " but got ";
    public static final String EXPECTED_AT_LEAST = "Expected at least ";
    // Consumer Loans
    public static final String EXPECTED = "Expected";
    public static final String INCOME_TXT = "შემოსავლით";
    // Locations
    public static final String BRANCHES_TXT = "ფილიალები";
    public static final String FILTER_LABEL = "24/7";
    // FAQ
    public static final String FAQ_TITLE = "ხშირად დასმული კითხვები";
    // Currency
    public static final String USD = "USD";
    public static final String GEL = "GEL";
    //DB
    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DEVELOPMENT = "development";
    public static final String DB_URL =
            "jdbc:h2:tcp://localhost:9093/./companyDB;MODE=MSSQLServer;DATABASE_TO_UPPER=FALSE;CASE_INSENSITIVE_IDENTIFIERS=TRUE";

    public static final String DB_USER = "sa";
    //API
    public static final String BASE_URI = "https://apigw.tbcbank.ge";
    public static final String BASE_PATH = "/api/v1/sites/pages";
    public static final String PAGE_ID = "4y4ZHuVsbZGrdtU9hV8jn2";
    public static final String PAGE_ENDPOINT = "/{pageId}";
    public static final String LOCALE = "ka-GE";
    public static final String LOCALE_KEY = "locale";
    public static final String PAGE_ID_KEY = "pageId";
    public static final String INVALID_PAGE_ID = "invalidPageId";
    public static final String CTA_SECTION = "ctaSection";
    public static final String EXPECTED_CTA_TITLE = "სამომხმარებლო სესხი";
    public static final String EXPECTED_CTA_LABEL = "მოითხოვეთ 80 000 ლარამდე თანხა 2 წუთში ნებისმიერი ადგილიდან.";
}
