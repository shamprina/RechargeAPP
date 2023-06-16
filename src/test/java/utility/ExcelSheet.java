package utility;

import java.io.IOException;
import java.io.FileInputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	public static String getDatafromExcel(int row,int cell) throws EncryptedDocumentException, IOException {
		String username;
		FileInputStream excel=new FileInputStream("C:/Users/DELL/eclipse-workspace/sicerepay/SincerePay/ExcelData/SincerePay.xlsx");
		Sheet a=WorkbookFactory.create(excel).getSheet("sheet1");
		try {
		username = a.getRow(row).getCell(cell).getStringCellValue();
		}catch(Exception e) {
		long pass=(long)a.getRow(row).getCell(cell).getNumericCellValue();
		username=""+pass;
		}
		return username;

		}
}
