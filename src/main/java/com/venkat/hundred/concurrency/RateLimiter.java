package com.venkat.hundred.concurrency;

//import java.util.concurrent.TimeUnit;
/*
7. Design a Rate Limiter
A Rate Limiter controls the rate of requests to a resource. Here’s a simple token bucket implementation.
 */
class RateLimiter {

    private final long maxTokens;
    private long availableTokens;
    private long lastRefillTime;
    private final long refillIntervalMillis;

    public RateLimiter(long maxTokens, long refillIntervalMillis) {
        this.maxTokens = maxTokens;
        this.availableTokens = maxTokens;
        this.refillIntervalMillis = refillIntervalMillis;
        this.lastRefillTime = System.currentTimeMillis();
    }

    // Acquire tokens from the bucket
    public synchronized boolean acquire() {
        refill();
        if (availableTokens > 0) {
            availableTokens--;
            return true;
        }
        return false;
    }

    // Refill tokens based on the elapsed time
    private void refill() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTime;

        if (elapsedTime > refillIntervalMillis) {
            availableTokens = Math.min(maxTokens, availableTokens + elapsedTime / refillIntervalMillis);
            lastRefillTime = now;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1000); // 5 requests per second

        for (int i = 0; i < 10; i++) {
            if (rateLimiter.acquire()) {
                System.out.println("Request " + i + " allowed.");
            } else {
                System.out.println("Request " + i + " denied.");
            }
            Thread.sleep(500);
        }
    }
}

