package com.wooz.compare.item.application.service;

import com.wooz.compare.item.application.port.in.GetTemplatesCommand;
import com.wooz.compare.item.application.port.in.GetTemplatesQuery;
import com.wooz.compare.item.application.port.out.GetTemplatesPort;
import com.wooz.compare.item.domain.TemplateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTemplatesService implements GetTemplatesQuery {
    private final GetTemplatesPort getTemplatesPort;

    @Override
    public List<TemplateEntity> getTemplates(GetTemplatesCommand command) {
        return getTemplatesPort.getTemplates(commandToEntity(command));
    }

    private TemplateEntity commandToEntity(GetTemplatesCommand command) {
        return new TemplateEntity(command.getTemplateId(), command.getName(), null);
    }
}
