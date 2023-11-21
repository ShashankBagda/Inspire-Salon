import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbersAndSymbol {
    public static void main(String[] args) {
        String text = "JSNHVSHD2NHS0FHN2HSFY3HDS-1JAH2GFBS-SAHS3JHG1";

        // Regular expression to match numbers and the '-' symbol
        Pattern pattern = Pattern.compile("[0-9-]+");
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();

        // Extracting numbers and '-' symbol and storing in a string
        while (matcher.find()) {
            result.append(matcher.group());
        }

        String extractedNumbersAndSymbol = result.toString();
        System.out.println("Extracted Numbers and Symbol: " + extractedNumbersAndSymbol);
    }
}
