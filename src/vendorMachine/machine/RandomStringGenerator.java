package vendorMachine.machine;

import java.util.Random;

/**
 * interface for generating a random product name
 */
public interface RandomStringGenerator {
    default String generateName() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
