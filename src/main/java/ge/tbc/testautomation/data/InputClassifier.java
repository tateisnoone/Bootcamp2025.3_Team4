package ge.tbc.testautomation.data;

public class InputClassifier {

    public static FieldType resolve(String value) {
        if (value.matches("\\d+")) {
            int len = value.length();

            if (len <= 4) return FieldType.PERSONAL;
            if (len >= 9) return FieldType.PHONE;

            return FieldType.PHONE;
        }

        return FieldType.NAME;
    }
}
