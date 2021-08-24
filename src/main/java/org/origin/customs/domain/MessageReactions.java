package org.origin.customs.domain;

import discord4j.common.util.Snowflake;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageReactions {

    Snowflake messageId;
    Set<ReactionActions> reactionActionsSet;
}
