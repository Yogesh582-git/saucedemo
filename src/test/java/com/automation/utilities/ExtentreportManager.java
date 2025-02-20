package com.automation.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.testcases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentreportManager implements ITestListener {

	public ExtentSparkReporter sparkReport;
	public ExtentReports extentReports;
	String repName;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String timeStamp = df.format(dt);

		repName = "Test-Report" + timeStamp + ".html";
		sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + repName);
//		System.getProperty("user.dir")+"\\Reports\\"+repName

		sparkReport.config().setDocumentTitle("Sauce Demo");
		sparkReport.config().setReportName("SauceDemo Report");
		sparkReport.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReport);
		extentReports.setSystemInfo("Application", "Sauce Demo");
		extentReports.setSystemInfo("Module", "Demo");
		extentReports.setSystemInfo("user name", "Swamy");
		extentReports.setSystemInfo("environment ", "QA");

		String browser = context.getCurrentXmlTest().getParameter("browser");

		List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includeGroups.isEmpty()) {
			extentReports.setSystemInfo("Groups", includeGroups.toString());
		}

		ITestListener.super.onStart(context);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + "got successfully executed");
		

		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		try {
			String imgPth = new BaseClass().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgPth);

		} catch (IOException e) {
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extentReports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "Test Skipped");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\Reports\\" + repName;
		File extentRepo = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentRepo.toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ITestListener.super.onFinish(context);
	}
}
