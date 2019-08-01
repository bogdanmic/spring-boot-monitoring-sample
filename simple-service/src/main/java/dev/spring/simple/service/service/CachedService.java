package dev.spring.simple.service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CachedService {

    @Cacheable(value = "cached_service", key = "{#root.methodName}", unless = "#result==null")
    public LocalDateTime getDate() {
        log.info("CACHE MISS!");
        return LocalDateTime.now();
    }

}