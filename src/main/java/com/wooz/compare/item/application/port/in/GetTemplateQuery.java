package com.wooz.compare.item.application.port.in;

import com.wooz.compare.item.domain.TemplateEntity;

public interface GetTemplateQuery {
    TemplateEntity execute(GetTemplateCommand getTemplateCommand);
}
