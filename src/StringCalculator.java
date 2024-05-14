public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check for custom delimiter
        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        // Split the numbers by delimiter and calculate the sum
        String[] nums = numbers.split("[" + delimiter + "\n]");
        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder(); // To collect negative numbers

        for (String num : nums) {
            int parsedNum = Integer.parseInt(num.trim()); // Trim whitespace before parsing
            if (parsedNum < 0) {
                if (negativeNumbers.length() > 0) {
                    negativeNumbers.append(",");
                }
                negativeNumbers.append(parsedNum);
            }
            sum += parsedNum;
        }

        // Throw exception if negative numbers are found
        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
