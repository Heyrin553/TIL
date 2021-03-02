package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String command=request.getParameter("command");
		String won=request.getParameter("won");
		String operator=request.getParameter("operator");
		
		if(command !=null && command.equals("calculate")) {
			String result=calculate(Float.parseFloat(won), operator);
			out.print("<html><font size=10>변환 결과</font><br>");
			out.print("<html><font size=10>"+result+"</font><br>");
			out.print("<a href='/Web13/calc'>환율 계산기</a>");
			return;
		}
		
		out.print("<html><title>환율 계산기</title>");
		out.print("<font size=5>환율 계산기</font><br>");
		out.print("<form name='frmCalc' method 'get' action='/Web13/calc' />");
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
