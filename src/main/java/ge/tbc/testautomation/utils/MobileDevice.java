package ge.tbc.testautomation.utils;

public enum MobileDevice {
    IPHONE_12_PRO(
            390,
            844,
            3.0,
            "Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1"
    );

    public final int width;
    public final int height;
    public final double scaleFactor;
    public final String userAgent;

    MobileDevice(int width, int height, double scaleFactor, String userAgent) {
        this.width = width;
        this.height = height;
        this.scaleFactor = scaleFactor;
        this.userAgent = userAgent;
    }
}