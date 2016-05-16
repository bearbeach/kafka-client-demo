# Kafka Client Introduction
```
A Kafka client that publishes records to the Kafka cluster.

The producer is thread safe and sharing a single producer instance across threads will generally be faster than having multiple instances.

Here is a simple example of using the producer to send records with strings containing sequential numbers as the key/value pairs.
```
