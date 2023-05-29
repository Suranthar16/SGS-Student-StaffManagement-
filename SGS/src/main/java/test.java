import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	   String a="2023-05";
	   SimpleDateFormat sf=new  SimpleDateFormat("yyyy-MM");
	   Date dte=sf.parse(a);
	   System.out.println(dte);
	   Calendar calendar = Calendar.getInstance();
		calendar.setTime(dte);
		System.out.println(calendar.getTime());
		 
	      double days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	      System.out.println(days);
	      
	      
	      
		    }
		 
		   

}
