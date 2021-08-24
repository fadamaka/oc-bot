package org.origin.customs.domain;

import discord4j.core.object.reaction.ReactionEmoji;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReactionActions {

    ReactionEmoji reactionEmoji;
    Set<BotAction> botActionSet;
}
