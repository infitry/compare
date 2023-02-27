package com.wooz.compare.item.application.service;

import com.wooz.compare.item.application.port.in.RegisterTemplateCommand;
import com.wooz.compare.item.application.port.in.RegisterTemplateUseCase;
import com.wooz.compare.item.application.port.out.RegisterTemplatePort;
import com.wooz.compare.item.domain.TemplateEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 템플릿 등록 UseCase
 */
@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class RegisterTemplateUseCaseImpl implements RegisterTemplateUseCase {
    private final RegisterTemplatePort registerTemplatePort;

    @Override
    public void execute(RegisterTemplateCommand registerTemplateCommand) {
        registerTemplatePort.registerTemplate(CommandToEntity(registerTemplateCommand));
    }

    /* Command 를 Entity 로 변환한다. */
    private TemplateEntity CommandToEntity(RegisterTemplateCommand registerTemplateCommand) {
        return new TemplateEntity(
                null,
                registerTemplateCommand.getName(),
                registerTemplateCommand.getComponents()
        );
    }
}
