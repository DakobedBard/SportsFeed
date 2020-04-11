package com.github.mddarr.kafka.producer.feed;

import com.typesafe.config.Config;

public class AppConfig {

    private final String bootstrapServers;
    private final String schemaRegistryUrl;
    private final String sourceTopicName;
    private final String applicationId;

    public AppConfig(Config config, String[] arguments) {
        this.bootstrapServers = "broker:29092";
        this.schemaRegistryUrl = "http://schema-registry:8081";
        this.sourceTopicName = "kafka.source.tweet.";
        this.applicationId = "my-app-v1.0.0"; //config.getString("kafka.streams.application.id");
    }

    public int getQueuCapacity(){return 100;}
    public String getBootstrapServers() {
        return bootstrapServers;
    }
    public String getSchemaRegistryUrl() {
        return schemaRegistryUrl;
    }
    public String getSourceTopicName() {
        return sourceTopicName;
    }
    public String getApplicationId() {
        return applicationId;
    }


}
