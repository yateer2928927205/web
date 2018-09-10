package web;

import com.java.util.SM4Code;

public class Sm4 {
     public static void main(String[] args) {
		
    	// System.out.println(SM4Code.getInstance().encrypt("{\"work_num\":\"1001010101\",\"apply_date\":\"to_data('09-08-2018'��'dd-mm-yyyy')\",\"apply_man\":\"admin\",\"work_type\":\"01\",\"title\":\"����\",\"templete_no\":\"1001201807030001\"}"));
    	// System.out.println(SM4Code.getInstance().encrypt("{\"jsonData\":\"[{'id':'2','busbarld':'3','voltageNow':'31'}, {'id':'0706','busbarld':'2','voltageNow':'30'}]\",\"businessId\":\"00000001\"}"));
	  
    	 
    	 System.out.println(SM4Code.getInstance().decrypt("nrmZtkF7T0kjG/VodDvBw93Ct8EgjCA+"));
     }
}
