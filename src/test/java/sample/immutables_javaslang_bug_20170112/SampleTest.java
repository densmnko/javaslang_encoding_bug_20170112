package sample.immutables_javaslang_bug_20170112;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javaslang.collection.List;
import javaslang.jackson.datatype.JavaslangModule;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * sample for https://github.com/javaslang/javaslang-jackson/issues/101
 */
public class SampleTest {
    @Test
    public void json_test() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaslangModule());
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());

        final Schema.Person value = PersonImpl.builder()
                .title("Mr")
                .name("John")
                .dob(LocalDate.now())
                .phones(List.of(
                        PhoneImpl.builder().number("555-55555").build(),
                        PhoneImpl.builder().number("42-424242").build()))
                .build();


        final String asString = mapper.writeValueAsString(value);
        assertNotNull(asString);
        System.out.println(asString);

        final Schema.Person value_decoded = mapper.readValue(asString, PersonImpl.class);
        assertEquals(value, value_decoded);
    }
}
