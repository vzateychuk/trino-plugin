package ru.vez.trino;

import io.trino.spi.eventlistener.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class QueryEventListener implements EventListener {
    private static final Logger log = LogManager.getLogger(QueryEventListener.class);

    @Override
    public void queryCreated(QueryCreatedEvent event) {
        log.info("Query Created: ID={} User={} Query=\"{}\"",
                event.getMetadata().getQueryId(),
                event.getContext().getUser(),
                event.getMetadata().getQuery());
    }

    @Override
    public void queryCompleted(QueryCompletedEvent event) {
        log.info("Query Completed: ID={} State={} Duration={}ms",
                event.getMetadata().getQueryId(),
                event.getMetadata().getQueryState(),
                event.getStatistics().getAnalysisTime().orElse(Duration.ZERO).toMillis());
    }
}