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
        for (String num : nums) {
            sum += Integer.parseInt(num.trim()); // Trim whitespace before parsing
        }
        return sum;
    }
}
