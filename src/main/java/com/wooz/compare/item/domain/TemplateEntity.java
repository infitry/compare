package com.wooz.compare.item.domain;

import com.wooz.compare.item.application.port.in.SelfValidating;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemplateEntity extends SelfValidating<TemplateEntity> {
    final UUID id;          // 아이디
    @NotEmpty
    @Size(min = 1, max = 50)
    final String name;      // 템플릿 명

    @NotNull
    final List<ComponentEntity> components;  // 컴포넌트

    public TemplateEntity(UUID id, String name, List<ComponentEntity> components) {
        this.id = id;
        this.name = name;
        this.components = components;
        this.validateSelf();
    }
}
