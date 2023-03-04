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
    public void execute(final RegisterTemplateCommand registerTemplateCommand) {
        registerTemplatePort.registerTemplate(CommandToEntity(registerTemplateCommand));
    }

    private TemplateEntity CommandToEntity(final RegisterTemplateCommand registerTemplateCommand) {
        return new TemplateEntity(
                null,
                registerTemplateCommand.getName(),
                registerTemplateCommand.getComponents()
        );
    }
}
