package web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.java.util.SM4Code;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
   public static void main(String[] args) {
	
//	    RestTemplate rest = new RestTemplate();
//		JSONObject json = new JSONObject();
//		json.put("data", "XFwSvbbe0bKvEGVw5JzwjAACRpnS4JujgOUfGSSDNd9WKnti+KsUo5B/BueKvrGMYDPSnV78zXjCDbmkYi60TDKpFO8b++SjCc1p8yiGEN/XMR7abfFDvmGouU5tDFtV+UumRKYOYzsfTYmZF4ATuec1kepzwADiLePwYQ3UYSNVwoYalsYHEnrw4cH3Z9vD");
//		String result = rest.postForObject("http://192.168.215.41:56911/pssc-wp-bs-uis-ordersyn/workOrder/reciveOrder", json.toString(), String.class);
//	   
	   
	   
	    RestTemplate rest = new RestTemplate();
			JSONObject json = new JSONObject();
			json.put("data", "传的参自己数据库配置");
			//MultiValueMap<String, Object> map=new LinkedMultiValueMap<>();
//			/pssc-wp-bs-uis-ordersyn/workOrder/reciveOrder   
			//XFwSvbbe0bKvEGVw5JzwjAACRpnS4JujgOUfGSSDNd9WKnti+KsUo5B/BueKvrGMyaMvlO48k67IrLDN8husTTKpFO8b++SjCc1p8yiGEN/XMR7abfFDvmGouU5tDFtVMSuoISi1vjYCB3MtWXy0SBQd+FxcZd20/RY8n4eYHJ4QShH5CgRb96Hsi0eBSHH8
			///pssc_sm_workflow/workflow/changeWorkFlowStateWithReturn    Th6I8YCEp4h/RBBu4auDxSzWjDXLKPvbBvg7w2HlfkeEPA/d89B1dHSrpapDcGvz3/nKroHPyT+Z2SNPQgKyJw==
		  //  Map<String, Object> map=new HashMap<String, Object>();
		  //  json.put("data", "Th6I8YCEp4h/RBBu4auDxSzWjDXLKPvbBvg7w2HlfkeEPA/d89B1dHSrpapDcGvz3/nKroHPyT+Z2SNPQgKyJw==");
			String result = rest.postForObject("http://192.168.215.41:56911/pssc-wp-bs-uis-ordersyn/orderSQL/allbusiness",json, String.class);
		    System.out.print(result);
		    JSONObject jsons=JSONObject.fromObject(result);
		    Object value= jsons.get("result");
		    String deString=SM4Code.getInstance().decrypt(value.toString());//解析result 对应的值
		    System.out.println(SM4Code.getInstance().decrypt(value.toString())); // 输出 解析result 对应的值
		    //后台打印  是这样一个格式   "[{\"ID\":23}]"
		    //正常是一个 jsonArray 字符串
		    String cc=  "[{\"ID\":23}]";
		    JSONArray jsonArray=JSONArray.fromObject(deString);
		    Object id=jsonArray.getJSONObject(0).get("ID");
}
}
