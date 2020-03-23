package com.shakya.rules;

public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);
    int value;

    Priority(int i) {
        this.value = i;
    }

}
