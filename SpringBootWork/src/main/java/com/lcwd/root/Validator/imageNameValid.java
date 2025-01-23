package com.lcwd.root.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//The @Retention annotation specifies how long an annotation should be retained,
//while the @Target annotation specifies where an annotation can be used.
@Target({ElementType.FIELD, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented //To ensure that our custom annotations are shown in the documentation, we use @Documented annotation to annotate our custom annotations.
@Constraint(validatedBy = imageNameValidator.class) //The @Constraint annotation in Java is used to mark an annotation as being a Bean Validation constraint.
public @interface imageNameValid {

    //error message
    String message() default "Invalid Image Name !!";

    //represent of constraints
    Class<?>[] groups() default {};

    //additional information about the annotation
    Class<? extends Payload>[] payload() default {};

}
