package ir.verjik.blacklist;

public interface TokenBlacklistService {
    /**
     * Blacklist the token for a given TTL in seconds.
     * If ttlSeconds <= 0 then token won't be stored (or can be stored with no expiry).
     */
    void blacklist(String token, long ttlSeconds);

    /**
     * Return true if token is blacklisted (i.e. should be rejected).
     */
    boolean isBlacklisted(String token);

    /**
     * Remove token from blacklist (optional).
     */
    void remove(String token);
}
