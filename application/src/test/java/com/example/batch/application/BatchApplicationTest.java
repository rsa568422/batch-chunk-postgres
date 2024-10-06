package com.example.batch.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@ExtendWith(MockitoExtension.class)
class BatchApplicationTest {

    @Test
    void mainTest() {
        // given
        var args = new String[0];

        try (var mockStatic = Mockito.mockStatic(SpringApplication.class)) {
            // when
            assertDoesNotThrow(() -> BatchApplication.main(args));

            // then
            mockStatic.verify(() -> SpringApplication.run(BatchApplication.class, args));
            mockStatic.verifyNoMoreInteractions();
        }
    }
}