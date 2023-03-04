package com.wooz.compare.item.domain;

import com.wooz.compare.item.application.port.in.SelfValidating;
import com.wooz.compare.item.domain.code.Type;
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
    final Type type;        // 타입
    @NotEmpty
    @Size(min = 5, max = 50)
    final String label;     // 라벨

    public ComponentEntity(UUID id, UUID templateId, Integer ordering, Type type, String label) {
        this.id = id;
        this.templateId = templateId;
        this.ordering = ordering;
        this.type = type;
        this.label = label;
        this.validateSelf();
    }
}
