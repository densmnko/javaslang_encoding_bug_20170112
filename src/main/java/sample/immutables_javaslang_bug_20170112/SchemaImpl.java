package sample.immutables_javaslang_bug_20170112;

import javaslang.collection.List;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.Optional;

@SampleStyle
public interface SchemaImpl {

    @Value.Immutable
    @JsonSerialize(as = PersonImpl.class)
    @JsonDeserialize(as = PersonImpl.class)
    abstract class AbstractPersonImpl implements Schema.Person {
        @Override
        abstract public Optional<String> title();
        @Override
        abstract public Optional<LocalDate> dob();
        @Override
        @JsonDeserialize(contentAs = PhoneImpl.class)
        abstract public List<Schema.Phone> phones();
    }

    @Value.Immutable
    @JsonSerialize(as = PhoneImpl.class)
    @JsonDeserialize(as = PhoneImpl.class)
    abstract class AbstractPhoneImpl implements Schema.Phone {

    }

}
