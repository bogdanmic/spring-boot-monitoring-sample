package dev.spring.simple.service.scheduler;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.spring.simple.service.service.CachedService;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConditionalOnProperty(prefix = "simple.scheduler.test", name = "enabled", havingValue = "true", matchIfMissing = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestScheduler {

    private final CachedService cachedService;

    @Scheduled(cron = "${simple.scheduler.test.cron}")
    public void executeJob() {
        log.info("Executing test scheduler at: {}", cachedService.getDate());
    }
}