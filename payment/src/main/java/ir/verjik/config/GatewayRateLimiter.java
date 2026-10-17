package ir.verjik.config;


import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GatewayRateLimiter {

    private final Map<String, Bucket> bucketMap = new ConcurrentHashMap<>();

    // ایجاد Bucket برای هر gateway
    public Bucket resolveBucket(String gatewayName) {
        return bucketMap.computeIfAbsent(gatewayName, key -> newBucket());
    }

    private Bucket newBucket() {
        Bandwidth limit = Bandwidth.classic(5, Refill.greedy(5, Duration.ofMinutes(1)));
        return Bucket.builder().addLimit(limit).build();
    }
}
