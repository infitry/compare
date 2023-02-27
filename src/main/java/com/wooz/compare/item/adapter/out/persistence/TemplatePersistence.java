package com.wooz.compare.item.adapter.out.persistence;

import com.wooz.compare.item.application.port.out.GetTemplatePort;
import com.wooz.compare.item.application.port.out.RegisterTemplatePort;
import com.wooz.compare.item.domain.TemplateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TemplatePersistence implements GetTemplatePort, RegisterTemplatePort {

    private final TemplateRepository templateRepository;
    private final TemplateMapper templateMapper;

    @Override
    public TemplateEntity getTemplate(UUID id) {
        return templateMapper.toEntity(templateRepository.findById(id).orElseThrow(() -> new NoSuchElementException("템플릿을 찾을 수 없습니다.")));
    }

    @Override
    public void registerTemplate(TemplateEntity template) {
        templateRepository.save(templateMapper.toJpaEntity(template));
    }
}
