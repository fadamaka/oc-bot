package org.origin.customs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotActionType {
    NOTIFICATION(1), ROLE_GRANT(2);

    int id;

}
