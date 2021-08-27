package org.origin.customs.main.event.reaction;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.reaction.ReactionEmoji;
import org.origin.customs.main.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactionAddListener implements EventListener<ReactionAddEvent> {

    @Autowired
    DiscordClient discordClient;

    @Override
    public Class<ReactionAddEvent> getEventType() {
        return ReactionAddEvent.class;
    }

    @Override
    public Mono<Void> execute(ReactionAddEvent event) {
        GatewayDiscordClient client = discordClient.login().block();

        Channel channel = client.getChannelById(Snowflake.of("874926593833852979")).block();

        Role role = client.getRoleById(Snowflake.of("874885766491291679"), Snowflake.of("874926393794920488")).block();

        return Mono.just(event).filter(rae -> rae.getChannelId().equals(Snowflake.of("875068506851401818")))
                .filter(rae -> rae.getMessageId().equals(Snowflake.of("875075391432327188")))
                .filter(rae -> rae.getEmoji().equals(ReactionEmoji.unicode("\uD83D\uDCBC")))
                .flatMap(rae -> rae.getUser())
                .flatMap(user -> channel.getRestChannel()
                        .createMessage("Hey " + role.getMention() + "s, We have a new client " + user.getMention()))
                .then();
    }
}
