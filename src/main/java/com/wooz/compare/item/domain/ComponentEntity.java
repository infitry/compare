package com.wooz.compare.item.domain;

import com.wooz.compare.item.domain.code.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentEntity {
    final UUID id;        // 아이디
    final UUID templateId;// template ID
    final int ordering;   // 순서
    final Type type;      // 타입
    final String label;   // 라벨
}
