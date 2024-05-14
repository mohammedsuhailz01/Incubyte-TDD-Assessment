public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        // Split the numbers by comma or newline and calculate the sum
        String[] nums = numbers.split("[,\n]");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num.trim()); // Trim whitespace before parsing
        }
        return sum;
    }
}
