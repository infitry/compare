package com.wooz.compare.item.application.port.in;

import com.wooz.compare.item.domain.TemplateEntity;

import java.util.List;

public interface GetTemplateQuery {
    TemplateEntity execute(GetTemplateCommand getTemplateCommand);
}
