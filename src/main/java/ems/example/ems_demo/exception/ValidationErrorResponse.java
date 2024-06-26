package ems.example.ems_demo.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<String> errors = new ArrayList<>();

    public void addError(String error) {
        errors.add(error);
    }

    // Getters and Setters
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
