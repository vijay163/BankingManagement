package newRepository;

import org.testng.annotations.Test;

public class TestClass
{
	@Test(priority = 4)
	public static void deleteApp()
	{
		System.out.println("Application is Deleted::::");
	}
	@Test(priority = 1)
	public static void createApp()
	{
		System.out.println("Application is Created::::");
	}
	@Test(priority = 3)
	public static void modifieFuture()
	{
		System.out.println("Application is Modified::::");
	}
	@Test(priority = 2)
	public static void addfuture()
	{
		System.out.println("New future is Added");
	}

}
