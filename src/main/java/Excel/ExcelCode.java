package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.wp.*;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelCode{

	

		public  FileInputStream f;

		public  XSSFWorkbook w;

		public  XSSFSheet s;

		public  String readStringData(int i,int j) throws IOException {

		f= new FileInputStream("C:\\Users\\HOME\\eclipse-workspace\\JavaTestProject\\src\\main\\resources\\Book1.xlsx");
		w= new XSSFWorkbook(f);
		s= w.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();



		}

		public  String readIntegerData(int i,int j) throws IOException {

		f= new FileInputStream("D:\\Excel\\Book1.xlsx");
		w= new XSSFWorkbook(f);
		s= w.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		int num =(int) c.getNumericCellValue();
		return String.valueOf(num);



		}

		
	}
