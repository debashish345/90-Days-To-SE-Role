package LLD.ratelimitter.tokenbucket;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public final class TokenBucketRateLimiter {
    private Instant windowStartTime = Instant.now();
    private volatile Integer tokenCount = 10;

    public void access() {
        if (!grantAccess()) {
            System.out.println("Access Denied !");
            return;
        }
        System.out.println("Request Granted.");
    }

    private boolean grantAccess() {
        if (tokenCount == 0) {
            refill();
            return false;
        }
        tokenCount--;
        return true;
    }

    private void refill() {
        if (windowStartTime.isBefore(Instant.now().minus(TokenBucketRLConfig.REFILL_TIME_IN_SEC, ChronoUnit.SECONDS))) {
            windowStartTime = Instant.now();
            tokenCount = TokenBucketRLConfig.ALLOWED_TOKEN_COUNT;
        }
    }
}
