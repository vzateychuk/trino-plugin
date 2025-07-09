# trino-plugin
Building a Trino SPI plugin to intercept and listen for query execution events — both in-flight and post-query

## ✅ Objective
Develop a Trino SPI plugin that:
- Listens to query start/execution
  - Hooks into query completed (post-query)
  - Performs custom logic like logging, metrics, or triggering external systems

## 🧠 Step-by-Step Development Plan
1. Understand Trino SPI and Extension Points
  Trino allows plugins via the SPI (trino-spi) module.
  Key interfaces:
   - EventListener – entry point for listening to query lifecycle events.
   - QueryCompletedEvent, QueryCreatedEvent, etc.

2. Setup Plugin Module
   Create a new Maven project with trino-spi as dependency.
   - Implement io.trino.spi.Plugin
   - Provide implementation of EventListenerFactory

3. Implement Event Listener Factory
   - Create a class that implements EventListenerFactory.
   - Return an instance of your custom EventListener from create().

4. Create Your Event Listener (Implement EventListener)
   - Override relevant methods:
   - queryCreated(QueryCreatedEvent event)
   - queryCompleted(QueryCompletedEvent event)

5. Add Custom Logic
   In each event method:
   - Log event details (e.g., query ID, user, query text)
   - Optionally send data to consumer (possible external systems: REST, Kafka, etc.)

6. Test the Plugin Locally
   - Package the plugin as a .jar
   - Deploy to Trino /plugin/your-plugin/ directory
   - Configure in etc/config.properties or etc/event-listener.properties:

7. Handle Errors and Performance
   - Ensure no exceptions bubble up — they could crash the coordinator 
   - Avoid long-running logic in listener methods
