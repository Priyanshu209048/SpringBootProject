package com.lcwd.root.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class imageNameValidator implements ConstraintValidator<imageNameValid, String> {

    private Logger logger = LoggerFactory.getLogger(imageNameValidator.class);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        logger.info("Message from isValid : {}", value);

        //logic
        /*if (value == null || value.trim().length() == 0) {*/
        if(value.isEmpty()){
            return false;
        } else {
            return true;
        }
    }
}
