package com.wooz.compare.item.application.port.out;

import com.wooz.compare.item.domain.TemplateEntity;

import java.util.List;

public interface GetTemplatesPort {
    List<TemplateEntity> getTemplates(TemplateEntity templateEntity);
}
