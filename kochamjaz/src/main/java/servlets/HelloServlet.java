package servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException { String name = request.getParameter("name");
	 * 
	 * response.setContentType("text/html");
	 * //response.setContentType("text/plaintext");
	 * 
	 * response.getWriter().println("<h1>Hello "+name+"</h1>");
	 * 
	 * }
	 */
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
{
	String kwota = request.getParameter("kwota");
	if(kwota==null || kwota.equals(""))
	{
		response.sendRedirect("/");
	}
	String raty = request.getParameter("raty");
	if(raty==null || raty.equals(""))
	{
		response.sendRedirect("/");
	}
	String oprocentowanie = request.getParameter("oprocentowanie");
	if(oprocentowanie==null || oprocentowanie.equals(""))
	{
		response.sendRedirect("/");
	}
	String oplata = request.getParameter("oplata");
	if(oplata==null || oplata.equals(""))
	{
		response.sendRedirect("/");
	}
	String typraty = request.getParameter("sel");
	oprocentowanie = oprocentowanie.replace(',', '.');	
	float ikwota = Float.parseFloat(kwota);
	int iraty = Integer.parseInt(raty);
	float ioprocentowanie = Float.parseFloat(oprocentowanie);
	float ioplata = Float.parseFloat(oplata);
	if(ikwota<0 || iraty<0 || ioprocentowanie<0 || ioplata<0)
	{
		response.sendRedirect("/");
	}
	
	response.setContentType("text/html");
	float kapital = (ikwota/iraty);
	float odsetki = 0;
	float ckr = 0;
	if(typraty.contentEquals("malejaca")) {
	response.getWriter().println("<table border='1'>" );
		for(int i=1;i<=iraty;i++) {
		
			ckr = (ikwota/iraty)*((1+((iraty-i+1)*((ioprocentowanie/100)/12))))+ioplata;
			odsetki = ckr - kapital - ioplata;
			response.getWriter().println("<tr><th>Rata nr: "+i+"</th><th>"
					+"Kwota kapitalu: "+Math.ceil(kapital)+"</th><th>"
					+"Kwota odsetek: "+Math.ceil(odsetki)+"</th><th>"
					+"Oplata stala: "+ioplata+"</th><th>"
					+"Calkowita rata: "+Math.ceil(ckr)+"</th>"
					+"</tr>");		
		}
		response.getWriter().println("</table>" );
	}else if(typraty.contentEquals("stala"))
	{
		response.getWriter().println("<table border='1'>" );
		ioprocentowanie = (ioprocentowanie/100);
		for(int i=1;i<=iraty;i++) {	
		ckr = (float) (
				(float) (((ikwota+ioplata)*(Math.pow((1+(ioprocentowanie/12)),iraty)))
				*((1+(ioprocentowanie/12))-1))
				/(Math.pow(((1+(ioprocentowanie/12))),(iraty))-1)
				);	
		odsetki = ckr - kapital;
		response.getWriter().println("<tr><th>Rata nr: "+i+"</th><th>"
				+"Kwota kapitalu: "+Math.ceil(kapital)+"</th><th>"
				+"Kwota odsetek: "+Math.ceil(odsetki)+"</th><th>"
				+"Oplata stala: "+ioplata+"</th><th>"
				+"Calkowita rata: "+Math.ceil(ckr)+"</th>"
				+"</tr>");	
		}
		response.getWriter().println("</table>" );
	}else {
		response.getWriter().println("ERROR");		
	}
	
	

}



}
