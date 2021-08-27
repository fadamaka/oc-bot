package org.origin.customs.main;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiscordClientFactory implements FactoryBean<DiscordClient> {

    @Value("${token}")
    private String token;

    @Override
    public DiscordClient getObject() throws Exception {
        return DiscordClientBuilder.create(token).build();
    }

    @Override
    public Class<?> getObjectType() {
        return DiscordClient.class;
    }
}
