package com.wooz.compare.item.application.port.in;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTemplatesCommand extends SelfValidating<GetTemplateCommand> {
    final UUID templateId;
    @Size(min = 1, max = 50)
    final String name;

    public GetTemplatesCommand(UUID templateId, String name) {
        this.templateId = templateId;
        this.name = name;
        this.validateSelf();
    }
}
