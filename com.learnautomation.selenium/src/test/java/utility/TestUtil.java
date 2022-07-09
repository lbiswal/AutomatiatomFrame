package utility;

import java.util.ArrayList;

public class TestUtil {
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromEcel(){
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("./TestData/Registration.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int rowNum =2;rowNum<=reader.getRowCount("user");rowNum++) {
			String fname = reader.getCellData("user", 1, rowNum);
			String lname =reader.getCellData("user", "lastname", rowNum);
			String email=reader.getCellData("user", "email", rowNum);
			String tel=reader.getCellData("user", "telephone", rowNum);
			String pwd =reader.getCellData("user", "password", rowNum);
			String cPwd =reader.getCellData("user", "passwordconfirm", rowNum);
			Object ob[] = {fname,lname,email,tel,pwd,cPwd};
			myData.add(ob);
		}
	return myData;

}
}
