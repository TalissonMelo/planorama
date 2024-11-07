package com.myorg;

import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecr.Repository;
import software.amazon.awscdk.services.ecr.RepositoryProps;
import software.amazon.awscdk.services.ecr.TagMutability;
import software.constructs.Construct;

public class EcrStack extends Stack {

    private final Repository planoramaBackendRepository;

    public EcrStack(final Construct construct, final String id, final StackProps props) {
        super(construct, id, props);


        this.planoramaBackendRepository = new Repository(this, "planorama_backend",
                RepositoryProps.builder()
                        .repositoryName("planorama")
                        .removalPolicy(RemovalPolicy.DESTROY)
                        .imageTagMutability(TagMutability.IMMUTABLE)
                        .autoDeleteImages(true)
                        .build());
    }

    public Repository getPlanoramaBackendRepository() {
        return planoramaBackendRepository;
    }
}
