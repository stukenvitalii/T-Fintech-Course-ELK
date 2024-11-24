package org.tinkoff.tfintechcourseelk.controller;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinkoff.tfintechcourseelk.service.ElkService;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ElkController {
    private final ElkService elkService;
    private final MeterRegistry meterRegistry;

    @GetMapping("/act")
    public String act() {
        var requestId = UUID.randomUUID().toString();

        var counter = meterRegistry.counter("requests.counter");
        try (var ignored = MDC.putCloseable("requestId", requestId)) {
            log.info("Getting response from ElkService...");
            counter.increment();
            return elkService.doSomething();
        }
    }
}
