package org.tinkoff.tfintechcourseelk.examples;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryExample {
    public static void main(String[] args) {
        List<int[]> memoryHog = new ArrayList<>();

        while (true) {
            memoryHog.add(new int[1_000_000]);
        }
    }
}