import java.io.*;
public class testLink{
    public static void main(String [] args){
	URL url = new URL("http://127.0.0.1:8080/Test/sendXmlAndReturnXml.do");
	String xml = "<aaa><ddd>cccccc客户端请求的xml数据cccccccc</ddd></aaa>";
	URLConnection conn = null;
	conn = url.openConnection();
	conn.setUseCaches(false);
	conn.setDoInput(true);
	conn.setDoOutput(true);
	conn.setRequestProperty("Content-Length", Integer.toString(xml.length()));
	conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
	OutputStream ops = conn.getOutputStream();
	OutputStreamWriter osw = new OutputStreamWriter(ops, "GBK");
	osw.write(xml);
	osw.flush();
	osw.close();
	
    //发送成功后，获取服务器的响应xml串：
	StringBuffer sb = new StringBuffer();
	String line = "";
	InputStream is = conn.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(is));//三层包装
	while ((line = br.readLine()) != null) {
	    sb.append(line+ "\r\n");
	}
    }
    System.out.println(sb.toString());  
}
