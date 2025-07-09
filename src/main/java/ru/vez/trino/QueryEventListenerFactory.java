package ru.vez.trino;

import io.trino.spi.eventlistener.EventListener;
import io.trino.spi.eventlistener.EventListenerFactory;

import java.util.Map;

public class QueryEventListenerFactory implements EventListenerFactory {
    @Override
    public String getName() {
        return "query-logger";
    }

    @Override
    public EventListener create(Map<String, String> config) {
        return new QueryEventListener();
    }
}