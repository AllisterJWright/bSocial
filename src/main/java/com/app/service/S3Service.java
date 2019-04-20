package com.app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class S3Service {

    public static String submitImage(InputStream i) throws IOException {
        String clientRegion = "us-east-2";
        String bucketName = "bsocial-0304-bucket";
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();

        try {
        	AWSCredentials credentials = new BasicAWSCredentials(
    				"AKIAR2XG2A3676MAYE63", 							// Access Key 
    				"eZbhtllqLDg2m6jfpvZEeW8lKdEsb+nCeC12IBqf"); 		// Secret Access Key
        	
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            		.withCredentials(new AWSStaticCredentialsProvider(credentials))
            		.withRegion(clientRegion)
                    .build();
        
            
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/jpg");
            metadata.addUserMetadata("x-amz-meta-title", "HEADER");
            
            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(bucketName, timestamp, i, metadata);
            
            s3Client.putObject(request);
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
        
        String amazonPrefix = "https://s3." + clientRegion + ".amazonaws.com/" + bucketName + "/";
        return amazonPrefix + timestamp;
    }
   
    public static S3Object getImage(String filename) throws IOException {
       String clientRegion = "us-east-2";
       String bucketName = "bsocial-0304-bucket";

       try {
       	AWSCredentials credentials = new BasicAWSCredentials(
   				"AKIAR2XG2A3676MAYE63", 							// Access Key 
   				"eZbhtllqLDg2m6jfpvZEeW8lKdEsb+nCeC12IBqf"); 		// Secret Access Key
       	
           AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
           		.withCredentials(new AWSStaticCredentialsProvider(credentials))
           		.withRegion(clientRegion)
                   .build();
       
           
           ObjectMetadata metadata = new ObjectMetadata();
           metadata.setContentType("image/jpg");
           metadata.addUserMetadata("x-amz-meta-title", "HEADER");
           
           // Upload a file as a new object with ContentType and title specified.
           S3Object fullObject = s3Client.getObject(new GetObjectRequest(bucketName, filename));
           System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
           System.out.println("Content: ");
           displayTextInputStream(fullObject.getObjectContent());
           return fullObject;
       }
       catch(AmazonServiceException e) {
           // The call was transmitted successfully, but Amazon S3 couldn't process 
           // it, so it returned an error response.
           e.printStackTrace();
       }
       catch(SdkClientException e) {
           // Amazon S3 couldn't be contacted for a response, or the client
           // couldn't parse the response from Amazon S3.
           e.printStackTrace();
       }
       
       return null;
	}
    
    private static void displayTextInputStream(InputStream input) throws IOException {
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println();
    }
}