package com.wooz.compare.item.application.port.out;

import com.wooz.compare.item.domain.TemplateEntity;

import java.util.UUID;

public interface GetTemplatePort {
    TemplateEntity getTemplate(UUID id);
}
