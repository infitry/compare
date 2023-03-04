package com.wooz.compare.item.adapter.out.persistence;

import com.wooz.compare.item.application.port.out.GetTemplatePort;
import com.wooz.compare.item.application.port.out.GetTemplatesPort;
import com.wooz.compare.item.application.port.out.RegisterTemplatePort;
import com.wooz.compare.item.domain.TemplateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TemplatePersistence implements GetTemplatePort, GetTemplatesPort, RegisterTemplatePort {

    private final TemplateRepository templateRepository;
    private final TemplateMapper templateMapper;

    @Override
    public TemplateEntity getTemplate(UUID id) {
        return templateMapper.toEntity(templateRepository.findById(id).orElseThrow(() -> new NoSuchElementException("템플릿을 찾을 수 없습니다.")));
    }

    @Override
    public TemplateEntity registerTemplate(TemplateEntity template) {
        return templateMapper.toEntity(templateRepository.save(templateMapper.toJpaEntity(template)));
    }

    @Override
    public List<TemplateEntity> getTemplates(TemplateEntity templateEntity) {
        return null;
    }
}
