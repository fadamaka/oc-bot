package org.origin.customs.domain;

import discord4j.core.object.entity.channel.Channel;
import discord4j.discordjson.json.MessageData;
import reactor.core.publisher.Mono;

public class NotificationAction implements BotAction<Mono<MessageData>, Channel> {

    @Override
    public BotActionType getBotActionType() {
        return BotActionType.NOTIFICATION;
    }

    @Override
    public Mono<MessageData> execute(Channel param) {
        return param.getRestChannel().createMessage("Notification");
    }
}
