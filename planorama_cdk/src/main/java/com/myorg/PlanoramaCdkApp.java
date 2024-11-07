package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.HashMap;
import java.util.Map;

public class PlanoramaCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        Environment environment = Environment.builder()
                .account("ACCOUNT_NUMBER")
                .region("REGION")
                .build();

        Map<String, String> infraTags = new HashMap<>();
        infraTags.put("team", "Planorama");
        infraTags.put("cost", "DevelopmentAndDevOps");

        EcrStack ecrStack = new EcrStack(app, "ECR", StackProps.builder()
                .env(environment)
                .tags(infraTags)
                .build());


        //ecrStack.getPlanoramaBackendRepository();

        app.synth();
    }
}

