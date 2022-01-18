package selenium.seleniumtest;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadingAndWritingExcel extends TestBase {

    @Test
    public void wikipediaTable(){

        extentTest.pass("1- Get the countr names and GDP, insert into map");
        driver.get("https://en.wikipedia.org/wiki/List_of_countries_by_GDP_(nominal)");
        List<WebElement> countries = driver.findElements(By.xpath("//table[2]//tbody//tr//td[1]"));
        List<WebElement> gdp = driver.findElements(By.xpath("//table[2]//tbody//tr//td[4]"));
        Map<String, String> countryGDP = new LinkedHashMap<>();

        for(int i = 0; i<countries.size(); i++){
            String countryName = countries.get(i).getText();
            String gdpOfCountries = gdp.get(i).getText();
            countryGDP.put(countryName,gdpOfCountries);
            writeToExcel(countryName,gdpOfCountries,i);
        }
        System.out.println(countryGDP);

    }

    public void  writeToExcel(String a, String b, int c) {
        try {
            String path = "./src/test/java/resources/CountryGDP.xlsx";
            FileInputStream fileInputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            sheet.createRow(0).createCell(0).setCellValue("COUNTRY");
            sheet.getRow(0).createCell(1).setCellValue("GDP");
            sheet.createRow(c+1).createCell(0).setCellValue(a);
            sheet.getRow(c+1).createCell(1).setCellValue(b);

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
