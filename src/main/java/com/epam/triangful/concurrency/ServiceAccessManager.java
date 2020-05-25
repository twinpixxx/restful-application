package com.epam.triangful.concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.concurrent.locks.ReentrantLock;

@Service("ServiceAccessManager")
public class ServiceAccessManager {
    private static final Logger logger = LogManager.getLogger();

    private static long requestCount;
    private ReentrantLock mutex;

    public ServiceAccessManager() {
        mutex = new ReentrantLock();
    }

    public void requestCounter() {
        try {
            mutex.lock();
            requestCount += 1;
            logger.info("Total count of requests = " + requestCount);
        } finally {
            mutex.unlock();
        }
    }

    public long getRequestCount() {
        return requestCount;
    }
}