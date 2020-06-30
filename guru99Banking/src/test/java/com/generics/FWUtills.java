package com.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Executable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FWUtills extends BaseClass implements IAutoConstants
{
	public static void takeScreenShot(WebDriver driver,String path)
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		FileUtils.copyFile(src, des);
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
	}
	public static void verifiePage(WebDriver driver,String expectedTitle)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
		System.out.println("Expected Title of page Displayed:::"+expectedTitle);
				
	}
	public static String read_XL_Data(String path,String sheet,int row,int cell)
	{
		String data=" ";
		try
		{
		Workbook ws = WorkbookFactory.create(new FileInputStream(path));
		data=ws.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return data;
	}
	public static int count_XL_DataRows(String path,String Sheet)
	{
		int rowCount=0;
		try
		{
		Workbook ws = WorkbookFactory.create(new FileInputStream(path));
		rowCount=ws.getSheet(Sheet).getLastRowNum();
	    }
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return rowCount;
	}
	public static void writedata_XL(String path,String sheet,int row,int cell,String cellValue)
	{
		try
		{
		Workbook ws = WorkbookFactory.create(new FileInputStream(path));
		ws.getSheet(sheet).createRow(row).createCell(cell).setCellValue(cellValue);
		ws.write(new FileOutputStream(path));
	    }
		catch (Exception e)
		{
		e.printStackTrace();
		}

    }
}