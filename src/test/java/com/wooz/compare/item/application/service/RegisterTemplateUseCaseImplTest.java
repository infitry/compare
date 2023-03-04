package com.wooz.compare.item.application.service;

import com.wooz.compare.item.application.port.in.RegisterTemplateCommand;
import com.wooz.compare.item.application.port.out.RegisterTemplatePort;
import com.wooz.compare.item.domain.ComponentEntity;
import com.wooz.compare.item.domain.TemplateEntity;
import com.wooz.compare.item.domain.code.ComponentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterTemplateUseCaseImplTest {

    @Mock
    RegisterTemplatePort registerTemplatePort;

    @InjectMocks
    RegisterTemplateUseCaseImpl registerTemplateUseCase;


    @Test
    @DisplayName("딱히 테스트할 건 없지만 Mocking 샘플")
    public void sampleTest() {
        // given
        var templateId = UUID.randomUUID();
        var templateName = "템플릿1";
        var component1Id = UUID.randomUUID();
        var component2Id = UUID.randomUUID();

        var component1 = new ComponentEntity(component1Id,templateId, 1, ComponentType.STRING, "이름");
        var component2 = new ComponentEntity(component2Id,templateId, 2, ComponentType.NUMBER, "나이");
        var components = List.of(component1, component2);
        var command = new RegisterTemplateCommand(templateName, List.of(component1, component2));
        var mockingTemplate = new TemplateEntity(templateId, templateName, components);
        // when
        when(registerTemplatePort.registerTemplate(any())).thenReturn(mockingTemplate);
        var result = registerTemplateUseCase.execute(command);
        // then
        assertEquals(templateId, result.getId(), "아이디는 모의객체와 같아야 한다.");
    }
}