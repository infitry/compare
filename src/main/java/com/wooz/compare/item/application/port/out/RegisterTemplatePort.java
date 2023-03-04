package com.wooz.compare.item.application.port.out;

import com.wooz.compare.item.domain.TemplateEntity;

public interface RegisterTemplatePort {
    TemplateEntity registerTemplate(TemplateEntity template);
}
