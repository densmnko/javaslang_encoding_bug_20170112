package sample.immutables_javaslang_bug_20170112;

import javaslang.collection.List;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface Schema {
    interface Person {
        Optional<String> title();
        String name();
        Optional<LocalDate> dob();
        List<Phone> phones();
    }

    interface Phone {
        String number();
    }
}
