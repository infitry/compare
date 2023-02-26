package com.wooz.compare.item.adapter.out.persistence;

import com.wooz.compare.item.adapter.out.persistence.code.Type;
import com.wooz.compare.item.application.port.out.GetTemplatePort;
import com.wooz.compare.item.application.port.out.RegisterTemplatePort;
import com.wooz.compare.item.domain.ComponentEntity;
import com.wooz.compare.item.domain.TemplateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TemplatePersistence implements GetTemplatePort, RegisterTemplatePort {

    private final TemplateRepository templateRepository;

    @Override
    public TemplateEntity getTemplate(UUID id) {
        return toEntity(templateRepository.findById(id).orElseThrow(() -> new NoSuchElementException("템플릿을 찾을 수 없습니다.")));
    }

    @Override
    public void registerTemplate(TemplateEntity template) {
        templateRepository.save(toJpaEntity(template));
    }

    private TemplateJpaEntity toJpaEntity(TemplateEntity templateEntity) {
        return TemplateJpaEntity.createTemplateJpaEntity(
                templateEntity.getName(),
                templateEntity.getComponentEntities().stream()
                        .map(componentEntity -> ComponentJpaEntity.createComponentJpaEntity(
                            componentEntity.getOrdering(),
                            Type.valueOf(componentEntity.getType().name()),
                            componentEntity.getLabel()
                        ))
                        .collect(Collectors.toList())
        );
    }

    private TemplateEntity toEntity(TemplateJpaEntity templateJpaEntity) {
        return new TemplateEntity(
                templateJpaEntity.getId(),
                templateJpaEntity.getTitle(),
                templateJpaEntity.getComponentJpaEntities().stream()
                        .map(componentJpaEntity -> new ComponentEntity(
                                componentJpaEntity.getId(),
                                componentJpaEntity.getTemplateJpaEntity().getId(),
                                componentJpaEntity.getOrdering(),
                                com.wooz.compare.item.domain.code.Type.valueOf(componentJpaEntity.getType().name()),
                                componentJpaEntity.getLabel())).collect(Collectors.toList())
        );
    }
}
