package sample.immutables_javaslang_bug_20170112;

import org.immutables.javaslang.encodings.JavaslangEncodingEnabled;
import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PACKAGE, ElementType.TYPE })
@Retention(RetentionPolicy.CLASS)
@Value.Style(
        typeAbstract = { "Abstract*" },
        typeImmutable = "*"
)
@JavaslangEncodingEnabled
public @interface SampleStyle {

}
