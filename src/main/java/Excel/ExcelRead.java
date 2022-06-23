package Excel;

import java.io.IOException;


public class ExcelRead {


		public static void main(String args[]) throws IOException {
			ExcelCode exc=new ExcelCode();
		String s = exc.readStringData(0,1);
		System.out.println(s);

		String n = exc.readIntegerData(0,0);
		System.out.println(n);
		}



		}


