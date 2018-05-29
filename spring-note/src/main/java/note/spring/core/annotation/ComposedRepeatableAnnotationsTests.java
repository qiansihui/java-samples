package note.spring.core.annotation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.annotation.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.core.annotation.AnnotatedElementUtils.getMetaAnnotationTypes;

/**
 * @Author qianqian.sun
 * @Date 2017/1/20
 * 描述：
 */
public class ComposedRepeatableAnnotationsTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void getMetaAnnotationTypesOnNonAnnotatedClass() {
        assertNull(getMetaAnnotationTypes(NonAnnotatedClass.class, TransactionalComponent.class));
        assertNull(getMetaAnnotationTypes(NonAnnotatedClass.class, TransactionalComponent.class.getName()));
        assertNotNull(getMetaAnnotationTypes(TransactionalComponentClass.class, TransactionalComponent.class.getName()));
        System.out.println(getMetaAnnotationTypes(TransactionalComponentClass.class, TransactionalComponent.class.getName()));
    }

    private static class NonAnnotatedClass {
    }

    @TransactionalComponent
    private static class TransactionalComponentClass {
    }

    @Transactional
    @Component
    @Retention(RetentionPolicy.RUNTIME)
    @interface TransactionalComponent {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Inherited
    @interface Transactional {

        String value() default "";

        String qualifier() default "transactionManager";

        boolean readOnly() default false;
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface Component {

        /**
         * The value may indicate a suggestion for a logical component name,
         * to be turned into a Spring bean in case of an autodetected component.
         *
         * @return the suggested component name, if any
         */
        public abstract String value() default "";

    }
}
