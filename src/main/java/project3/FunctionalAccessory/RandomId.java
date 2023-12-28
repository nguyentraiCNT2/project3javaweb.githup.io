package project3.FunctionalAccessory;

import java.security.SecureRandom;

public class RandomId {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static String generateRandomId(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder randomId = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            randomId.append(randomChar);
        }

        return randomId.toString();
    }
    public static void main(String[] args) {
        // Generate a random ID with a minimum length of 50 characters
        String randomId = generateRandomId(20);
        System.out.println("Random ID: " + randomId);
    }
}
