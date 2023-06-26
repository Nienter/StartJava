package com.example.lib2;

public class ProcessArrat {
    public void process(int[] targets, Command command) {
        for (int i = 0; i < targets.length; i++) {
            command.process(i);
        }
    }
}
