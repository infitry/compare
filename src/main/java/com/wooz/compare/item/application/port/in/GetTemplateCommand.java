package com.wooz.compare.item.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTemplateCommand extends SelfValidating<GetTemplateCommand> {
    @NotNull
    final UUID templateId;  // 템플릿 아이디

    public GetTemplateCommand(UUID templateId) {
        this.templateId = templateId;
        this.validateSelf();
    }
}
