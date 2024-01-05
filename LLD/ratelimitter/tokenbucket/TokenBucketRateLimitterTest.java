package LLD.ratelimitter.tokenbucket;

import java.util.Random;

public class TokenBucketRateLimitterTest {

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter tbRateLimitter = new TokenBucketRateLimiter();

        for (int i=0; i<1000; i++) {
            tbRateLimitter.access();
            Thread.sleep(new Random().nextInt(500));
        }
    }
}
