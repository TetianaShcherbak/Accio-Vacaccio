package com.codecool.travelhelper.aws.imagestore.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {
//        AWSCredentials awsCredentials = new BasicAWSCredentials(
//          "AKIA3DOEMU2MIPGZ4TM4",
//          "EdmKvizcTZPwH9S+6lI/Tye6HE599JaKEWTLW+L/"
//        );

        AWSCredentials awsCredentials = new BasicAWSCredentials(
          "AKIA5U45OMHKNGUHM44K",
          "qYnCtjSi6+yuGj2REsip/bACln476yQnBtnlZvGG"
        );
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("us-west-2")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

}
