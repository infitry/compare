package com.wooz.compare.item.domain;

import com.wooz.compare.item.application.port.in.SelfValidating;
import com.wooz.compare.item.domain.code.ComponentType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentEntity extends SelfValidating<ComponentEntity> {
    final UUID id;          // 아이디
    @NotNull
    final UUID templateId;  // template ID
    @NotNull
    final Integer ordering; // 순서
    @NotNull
    final ComponentType componentType;        // 타입
    @NotEmpty
    @Size(min = 1, max = 50)
    final String label;     // 라벨

    public ComponentEntity(UUID id, UUID templateId, Integer ordering, ComponentType componentType, String label) {
        this.id = id;
        this.templateId = templateId;
        this.ordering = ordering;
        this.componentType = componentType;
        this.label = label;
        this.validateSelf();
    }
}
