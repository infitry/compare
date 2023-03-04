package com.wooz.compare.item.application.service;

import com.wooz.compare.item.application.port.in.GetTemplateCommand;
import com.wooz.compare.item.application.port.in.GetTemplateQuery;
import com.wooz.compare.item.application.port.out.GetTemplatePort;
import com.wooz.compare.item.domain.TemplateEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 템플릿 조회
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class GetTemplateService implements GetTemplateQuery {
    private final GetTemplatePort getTemplatePort;

    @Override
    public TemplateEntity execute(final GetTemplateCommand getTemplateCommand) {
        return getTemplatePort.getTemplate(getTemplateCommand.getTemplateId());
    }
}
