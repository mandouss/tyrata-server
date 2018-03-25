import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.lang3.StringUtils;

public class TestXMLAction extends HttpServlet {  
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        //get request xml from client
	String reqXml =  getXmlFromRequest(request);
     
	// System.out.println("receive xml：\n" + getXmlFromRequest(request));  
        //response: a xml back to client 
	response.getWriter().print("<server>xinb   "+ reqXml +"   uxin</server>");
	//response.getWriter().print(sendXmlAndReturnXml());  
        //response.getWriter().print(reqXml); 
    }  
      
    //extract XML from http request
    private String getXmlFromRequest(HttpServletRequest request)throws IOException {  
        String reqXml = "";  
        reqXml = request.getQueryString(); //GET 
        if (StringUtils.isBlank(reqXml)) { //POST 
            BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));  
            String line = null;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {  
                sb.append(line);  
            }  
            br.close();  
            reqXml = sb.toString();  
        }  
        return reqXml;  
    }  
    /*private String sendXmlFromRequest() throw IOException {

    }*/

}  
