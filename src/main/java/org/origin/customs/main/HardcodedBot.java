package org.origin.customs.main;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.event.domain.message.ReactionAddEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.Role;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.reaction.ReactionEmoji;

public final class HardcodedBot {

    public static void main(final String[] args) {
        final DiscordClient client = DiscordClient.create(args[0]);

        Channel channel = client.login()
                .flatMapMany(gateway -> gateway.getChannelById(Snowflake.of("874926593833852979"))).blockFirst();

        Message message = client.login().flatMapMany(gateway -> gateway
                .getMessageById(Snowflake.of("875068506851401818"), Snowflake.of("875075391432327188"))).blockFirst();

        Role role = client.login().flatMapMany(
                gateway -> gateway.getRoleById(Snowflake.of("874885766491291679"), Snowflake.of("874926393794920488")))
                .blockFirst();

        client.login().flatMapMany(gateway -> gateway.on(ReactionAddEvent.class))
                .filter(rae -> rae.getChannelId().equals(Snowflake.of("875068506851401818")))
                .filter(rae -> rae.getMessageId().equals(Snowflake.of("875075391432327188")))
                .filter(rae -> rae.getEmoji().equals(ReactionEmoji.unicode("\uD83D\uDCBC")))
                .flatMap(rae -> rae.getUser())
                .flatMap(user -> channel.getRestChannel()
                        .createMessage("Hey " + role.getMention() + "s, We have a new client " + user.getMention()))
                .blockFirst();
    }
}