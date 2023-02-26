package com.wooz.compare.item.application.port.in;

import com.wooz.compare.item.domain.ComponentEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class RegisterTemplateCommand {
    final String name;      // 템플릿 명
    final List<ComponentEntity> componentEntity;  // 컴포넌트
}
