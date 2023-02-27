package com.wooz.compare.item.adapter.out.persistence;

import com.wooz.compare.item.adapter.out.persistence.code.Type;
import com.wooz.compare.item.domain.ComponentEntity;
import com.wooz.compare.item.domain.TemplateEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TemplateMapper {
    TemplateEntity toEntity(TemplateJpaEntity templateJpaEntity) {
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

    TemplateJpaEntity toJpaEntity(TemplateEntity templateEntity) {
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
}
