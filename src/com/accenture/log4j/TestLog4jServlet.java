package com.accenture.log4j;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/test")
public class TestLog4jServlet extends HttpServlet{
	
	/**
	 * Testing the log4J functionality. 
	 */
	private static final long serialVersionUID = 1421058210432802214L;
	static final Logger LOGGER = Logger.getLogger(TestLog4jServlet.class);
	static final Logger debugLog = Logger.getLogger("errorLogger");
	static final Logger infoLog = Logger.getLogger("infoLogger");
	
	/*public static void main(String[] args) {
		LOGGER.info("This is a logging statement from log4j");
	}*/
    
    @Override
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
          
    	debugLog.error("This is a logging statement from log4j");
    	infoLog.debug("This is a logging statement from log4j");
        infoLog.info("This is a logging statement from log4j");
         
        String html = "<html><h2>Log4j has been initialized successfully! Please see the console for more Info</h2></html>";
        response.getWriter().println(html);
    }
}
