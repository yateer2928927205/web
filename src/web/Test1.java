package web;

import com.sgitg.sgcc.sm.SM4Utils;

public class Test1 {
	private static SM4Utils aa=new SM4Utils();
	
	
	//自己加密和解密
	//单步加解密
	public static void en_decryptData_ECB() {
		
			String keyStr="1122334455667788";
			String cipherStrings="0E28E38932C6FD7B1446A41396824A25";

			byte[] cc="00".getBytes();
			byte[] dd="00".getBytes();
			
				byte[] keyBytes=keyStr.getBytes();
				byte[] cipherText=cipherStrings.getBytes();

				cc="00".getBytes();
				dd="00".getBytes();
				
				try {
					String str = new String(cipherText);
					System.out.println("加密前数据为="+str);
					cc=aa.SG_EncECBData(keyBytes, cipherText);
					
				} catch (Exception e) {

					System.out.println(e.toString());
				}
		
				if(cc==null){
					System.out.println("encryptData_ECB Err:null");
					return ;
				}
				
				try {
					
					dd= aa.SG_DecECBData(keyBytes, cc);
					String str1 = new String(dd);
					System.out.println("解密后数据为="+str1);
				} catch (Exception e) {

					System.out.println(e.toString());
				}
				
				if(dd==null){
					System.out.println("decryptData_ECB Err:null");
					return ;
				}
				
		}
		
}
