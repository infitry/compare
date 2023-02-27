package com.wooz.compare.item.application.port.in;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SelfValidatingTest {

    public static class TestCommand extends SelfValidating<TestCommand> {
        @NotNull
        UUID id;

        @NotNull
        @Size(min = 1, max = 50, message = "이름은 최소 1글자 부터 최대 50글자 이어야 합니다.")
        String name;

        public TestCommand(UUID id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    @DisplayName("유효성검증 테스트")
    public void selfValidatingTest() {
        // given
        UUID expId = UUID.randomUUID();
        String name = "";
        // when
        TestCommand testCommand = new TestCommand(expId, name);
        // then
        assertThrows(ConstraintViolationException.class, testCommand::validateSelf, "이름의 사이즈가 0이기 때문에 ConstraintViolationException 발생");
    }
}