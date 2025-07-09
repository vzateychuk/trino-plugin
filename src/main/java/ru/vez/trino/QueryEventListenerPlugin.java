package ru.vez.trino;

import io.trino.spi.Plugin;
import io.trino.spi.eventlistener.EventListenerFactory;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

public class QueryEventListenerPlugin implements Plugin {
    @Override
    public Iterable<EventListenerFactory> getEventListenerFactories() {
        return Collections.singleton(new QueryEventListenerFactory());
    }
}