package com.david.mainproject.DBConfig;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.david.mainproject.repository")
public class DynamoDBConfig {

  @Value("${endpoint}")
  private String endpoint;
  @Value("${region}")
  private String region;
  @Value("${amazon.aws.accesskey}")
  private String accessKey;
  @Value("${amazon.aws.secretkey}")
  private String secreKey;


  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    AmazonDynamoDB amazonDynamoDB
        = new AmazonDynamoDBClient(awsCredentialsProvider());

    if (!StringUtils.isEmpty(endpoint)) {
      amazonDynamoDB.setEndpoint(endpoint);
    }

    return amazonDynamoDB;

  }

  @Bean
  public AWSCredentialsProvider awsCredentialsProvider() {
    return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secreKey));
  }
}