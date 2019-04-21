package com.service;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.services.S3Service;

public class S3ServiceTest
{
	@Before
	public void beforeTest()
	{
		System.out.println("STARTING NEW TEST");
	}
	
	@After
	public void afterTest()
	{
		System.out.println("TEST RUN COMPLETE");
	}
	
	@Test
	public void getImageTest()
	{
		try
		{
			System.out.println(S3Service.getImage("inigo.jpeg").toString());
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("IOException Occurred");
		}
	}
	
	@Test
	public void submitImageTest()
	{
		try
		{
			System.out.println(S3Service.submitImage(new FileInputStream(new File("src/test/resources/testPost.jpeg"))));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			fail("IOException occurred");
		}
	}
}
