package com.wooz.compare.item.application.port.in;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTemplateCommand {
    // TODO validation 처리
    final UUID templateId;  // 템플릿 아이디
}
