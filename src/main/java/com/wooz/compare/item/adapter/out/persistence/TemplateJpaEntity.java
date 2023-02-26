package com.wooz.compare.item.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_TEMPLATE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TemplateJpaEntity {
    @Id
    @UuidGenerator
    UUID id;

    @Column
    String title;

    @OneToMany(mappedBy = "id")
    final List<ComponentJpaEntity> componentJpaEntities = new ArrayList<>();

    //== 생성자 ==//
    public TemplateJpaEntity(String title, ComponentJpaEntity... componentJpaEntities) {
        this.title = title;
        this.componentJpaEntities.addAll(Arrays.stream(componentJpaEntities).toList());
    }

    public TemplateJpaEntity(String title, List<ComponentJpaEntity> componentJpaEntities) {
        this.title = title;
        this.componentJpaEntities.addAll(componentJpaEntities);
    }

    //== 생성 메서드 ==//
    public static TemplateJpaEntity createTemplateJpaEntity(String title, ComponentJpaEntity... componentJpaEntities) {
        return new TemplateJpaEntity(title, componentJpaEntities);
    }
    public static TemplateJpaEntity createTemplateJpaEntity(String title, List<ComponentJpaEntity> componentJpaEntities) {
        return new TemplateJpaEntity(title, componentJpaEntities);
    }
}
