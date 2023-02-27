package com.wooz.compare.item.application.port.in;

import com.wooz.compare.item.domain.TemplateEntity;

import java.util.List;

public interface GetTemplatesQuery {
    List<TemplateEntity> getTemplates(GetTemplatesCommand command);
}
