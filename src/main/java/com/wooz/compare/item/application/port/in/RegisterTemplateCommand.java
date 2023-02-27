package com.wooz.compare.item.application.port.in;

import com.wooz.compare.item.domain.ComponentEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterTemplateCommand extends SelfValidating<RegisterTemplateCommand> {
    @NotNull
    @Size(min = 1, max = 50, message = "템플릿 명은 최소 1 ~ 최대 50 글자 입니다.")
    final String name;          // 템플릿 명
    final List<ComponentEntity> components;  // 컴포넌트

    public RegisterTemplateCommand(String name, List<ComponentEntity> components) {
        this.name = name;
        this.components = components;
        this.validateSelf();
    }
}
