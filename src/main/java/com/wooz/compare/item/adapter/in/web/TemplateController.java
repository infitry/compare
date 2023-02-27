package com.wooz.compare.item.adapter.in.web;

import com.wooz.compare.item.application.port.in.*;
import com.wooz.compare.item.domain.ComponentEntity;
import com.wooz.compare.item.domain.TemplateEntity;
import com.wooz.compare.item.domain.code.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/templates")
@RequiredArgsConstructor
public class TemplateController {
    private final GetTemplateQuery getTemplateQuery;
    private final GetTemplatesQuery getTemplatesQuery;
    private final RegisterTemplateUseCase registerTemplateUseCase;

    @GetMapping(value = "/{templateId}")
    public TemplateEntity getTemplate(@PathVariable UUID templateId) {
        return getTemplateQuery.execute(new GetTemplateCommand(templateId));
    }

    @GetMapping
    public List<TemplateEntity> getTemplates(GetTemplatesRequest getTemplatesRequest) {
        return getTemplatesQuery.getTemplates(
                new GetTemplatesCommand(getTemplatesRequest.id(), getTemplatesRequest.name())
        );
    }

    @PostMapping
    public void registerTemplate(@RequestBody RegisterTemplateRequest registerTemplateRequest) {
        registerTemplateUseCase.execute(
                new RegisterTemplateCommand(
                    registerTemplateRequest.name(),
                    registerTemplateRequest.componentRequests().stream().map( componentRequest ->
                            new ComponentEntity(null, null, componentRequest.ordering(), componentRequest.type(), componentRequest.label()))
                            .collect(Collectors.toList())
                )
        );
    }

    // 템플릿 등록 요청
    public record RegisterTemplateRequest(
            String name,      // 템플릿 명
            List<RegisterComponentRequest> componentRequests  // 컴포넌트
    ) {}

    // 템플릿 목록 요청
    public record GetTemplatesRequest(
            UUID id,
            String name
    ) {}

    // 컴포넌트 등록 요청
    public record RegisterComponentRequest(
            int ordering,  // 순서
            Type type,     // 타입
            String label   // 라벨
    ) {}
}
