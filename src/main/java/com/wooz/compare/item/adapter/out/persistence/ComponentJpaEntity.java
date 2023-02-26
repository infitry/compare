package com.wooz.compare.item.adapter.out.persistence;

import com.wooz.compare.item.adapter.out.persistence.code.Type;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComponentJpaEntity {
    @Id
    @UuidGenerator
    UUID id;        // 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    TemplateJpaEntity templateJpaEntity;

    @Column
    int ordering;   // 순서

    @Enumerated(EnumType.STRING)
    Type type;      // 타입

    @Column
    String label;   // 라벨

    //== 생성자 ==//
    public ComponentJpaEntity(int ordering, Type type, String label) {
        this.ordering = ordering;
        this.type = type;
        this.label = label;
    }

    //== 생성 메서드 ==//
    public static ComponentJpaEntity createComponentJpaEntity(int ordering, Type type, String label) {
        return new ComponentJpaEntity(ordering, type, label);
    }

    //== 연관 관계 메서드 ==//
    private void addTemplate(TemplateJpaEntity templateJpaEntity) {
        this.templateJpaEntity = templateJpaEntity;
        this.templateJpaEntity.getComponentJpaEntities().add(this);
    }
}
