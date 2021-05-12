package com.example.infrastructure.uitl;

import java.util.UUID;

public class GuidGenerator {

    public static String generator() {
        return UUID.randomUUID().toString();
    }

}
