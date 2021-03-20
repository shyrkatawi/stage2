package exceptionstask.entities;

import exceptionstask.exceptions.IllegalGradeException;

public class Grade {
    private static final int MINIMAL_POSSIBLE_GRADE = 0;
    private static final int MAXIMUM_POSSIBLE_GRADE = 10;
    private final int value;

    public Grade(int value) {
        if(value < MINIMAL_POSSIBLE_GRADE || value > MAXIMUM_POSSIBLE_GRADE){
            throw new IllegalGradeException(String
                    .format("ERROR, the grade must be in the range from %d to %d inclusive(%d<=score<=%d)",
                            MINIMAL_POSSIBLE_GRADE,
                            MAXIMUM_POSSIBLE_GRADE,
                            MINIMAL_POSSIBLE_GRADE,
                            MAXIMUM_POSSIBLE_GRADE
                    ));
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
