package com.wooz.compare.item.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemplateEntity {
    final UUID id;          // 아이디
    final String name;      // 템플릿 명
    final List<ComponentEntity> components;  // 컴포넌트
}
