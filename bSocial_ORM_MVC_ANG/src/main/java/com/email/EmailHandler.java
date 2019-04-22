package com.email;

import java.io.IOException;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class EmailHandler
{

	static AWSCredentials credentials = new BasicAWSCredentials("AKIAR2XG2A363RA436BO", // Access Key ID
			"dzwjiFoVQIN2FY5xm9jluljmSREOA07e8gqebAk6"); // Secret Access Key

	// Replace sender@example.com with your "From" address.
	// This address must be verified with Amazon SES.
	static final String FROM = "bSocialable@gmail.com";

	// Replace recipient@example.com with a "To" address. If your account
	// is still in the sandbox, this address must be verified.
	static String TO = "";

	// The configuration set to use for this email. If you do not want to use a
	// configuration set, comment the following variable and the
	// .withConfigurationSetName(CONFIGSET); argument below.
	// static final String CONFIGSET = "ConfigSet";

	// The subject line for the email.
	static final String SUBJECT = "EMAIL FROM AWS!!!";

	// The HTML body for the email.
	static String HTMLBODY = "";

	// The email body for recipients with non-HTML email clients.
	static final String TEXTBODY = "Like OMG!" + "TOTALLY NOT A SCAM";

	public static void setReceiver(String rec)
	{
		TO = rec;
	}

	public static void sendEmail(String newPassword) throws IOException
	{

		System.out.println("**cries**");

		try
		{
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider(credentials))
					.withRegion(Regions.US_EAST_1)
					.build();
			HTMLBODY = "<h1>bSocial: Password Reset Request</h1>"
					+ "<p>ONE TIME PASSWORD: "+ newPassword +"</p>"
							+ "<p><a href='http://localhost:4200/login'>" +"~~~~~~~~Click here to login 🐝~~~~~~~~</a></p>";

			SendEmailRequest request = new SendEmailRequest().withDestination(new Destination()
															 .withToAddresses(TO))
															 .withMessage(new Message()
															 .withBody(new Body()
															 .withHtml(new Content()
															 .withCharset("UTF-8")
															 .withData(HTMLBODY))
															 .withText(new Content()
															 .withCharset("UTF-8")
															 .withData(TEXTBODY)))
															 .withSubject(new Content()
															 .withCharset("UTF-8")
															 .withData(SUBJECT)))
															 .withSource(FROM);
			System.out.println("**cries**");
			client.sendEmail(request);
			System.out.println("Email sent!");
		}
		catch (Exception ex)
		{
			System.out.println("Error message: " + ex.getMessage());
		}
	}
}