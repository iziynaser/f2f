package ir.verjik.blacklist;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.time.Duration;

@Service
public class RedisTokenBlacklistService implements TokenBlacklistService {

    private final StringRedisTemplate redisTemplate;
    private static final String PREFIX = "jwt:blacklist:";

    public RedisTokenBlacklistService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void blacklist(String token, long ttlSeconds) {
        if (token == null || token.isEmpty()) return;
        String key = PREFIX + token;
        if (ttlSeconds > 0) {
            redisTemplate.opsForValue().set(key, "1", Duration.ofSeconds(ttlSeconds));
        } else {
            // store without TTL (not recommended) — here we set a long TTL (e.g., 30 days) as fallback
            redisTemplate.opsForValue().set(key, "1", Duration.ofDays(30));
        }
    }

    @Override
    public boolean isBlacklisted(String token) {
        if (token == null || token.isEmpty()) return false;
        String key = PREFIX + token;
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    @Override
    public void remove(String token) {
        if (token == null || token.isEmpty()) return;
        redisTemplate.delete(PREFIX + token);
    }
}
