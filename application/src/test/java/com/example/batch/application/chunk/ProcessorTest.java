package com.example.batch.application.chunk;

import com.example.batch.application.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {Processor.class})
class ProcessorTest {

    @Autowired
    private Processor processor;

    @Test
    void process() {
        // when
        var actual = processor.process(Data.ENTRADA_1);

        // then
        assertNotNull(actual);
        assertEquals(Data.SALIDA_1.getTotal(), actual.getTotal());
    }
}