package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.VpcProps;
import software.amazon.awscdk.services.ecr.Repository;
import software.constructs.Construct;

public class VpcStack extends Stack {

    private final Vpc vpc;

    public VpcStack(final Construct construct, final String id, final StackProps props) {
        super(construct, id, props);

        this.vpc = new Vpc(this, "VPC", VpcProps.builder()
                .vpcName("Planorama")
                .maxAzs(2)
                //.natGateways(0) Do not do this in Production
                .build());

    }

    public Vpc getVpc() {
        return vpc;
    }
}
