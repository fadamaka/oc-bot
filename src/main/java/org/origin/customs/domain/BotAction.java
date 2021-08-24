package org.origin.customs.domain;

public interface BotAction<R, P> {

    BotActionType getBotActionType();

    R execute(P param);
}
