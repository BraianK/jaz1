package servlets;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;
import com.itextpdf.text.DocumentException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String kwota = request.getParameter("kwota");
    String raty = request.getParameter("raty");
    String oprocentowanie = request.getParameter("oprocentowanie");
    oprocentowanie = oprocentowanie.replace(",", ".");
    String oplata = request.getParameter("oplata");
    String sel = request.getParameter("sel");
    String akcja = request.getParameter("akcja");
    if (kwota == null || kwota.equals("") || raty == null || raty.equals("") || oprocentowanie == null || oprocentowanie.equals("") || oplata == null || oplata.equals("")) {
        response.sendRedirect("/");
    }

    float iKwota = Float.parseFloat(kwota);
    int iraty = Integer.parseInt(raty);
    float iOprocentowanie = Float.parseFloat(oprocentowanie);
    float iOplata = Float.parseFloat(oplata);

    if (iKwota < 0 || iraty < 0 || iOprocentowanie < 0 || iOplata < 0) {
        response.sendRedirect("/");
    }
    if (akcja.contentEquals("pdf")) {
    	generatePdf(przygotuj(sel, iraty, iOprocentowanie, iOplata, iKwota),response);
    } else {
    	response.setContentType("text/html");
        response.getWriter().println(przygotuj(sel, iraty, iOprocentowanie, iOplata, iKwota));
    	        	
    }
}
private String przygotuj(String sel, int raty, float oprocentowanie, float oplata, float kwota) {
        StringBuilder stringBuilder = new StringBuilder();
        float kapital = (kwota / raty);
        float odsetki = 0;
        float allKwota = 0;
        
        if (sel.contentEquals("malejaca")) {
        	stringBuilder.append("<table border='1'>");

            for (int i = 1; i <= raty; i++) {

                allKwota = (kwota / raty) * ((1 + ((raty - i + 1) * ((oprocentowanie / 100) / 12)))) + oplata;
                odsetki = allKwota - kapital - oplata;
                stringBuilder.append("<tr><th>Rata nr: " + i + "</th><th>"
                + "Kwota kapitalu: " + Math.ceil(kapital) + "</th><th>" 
                + "Kwota odsetek: " + Math.ceil(odsetki) + "</th><th>" 
                + "Oplata stala: " + oplata + "</th><th>"
                + "Calkowita rata: " + Math.ceil(allKwota) + "</th></tr>");
            }
            
            stringBuilder.append("</table>");
            
        } else {
        	
        	stringBuilder.append("<table border='2'>");
            oprocentowanie = (oprocentowanie / 100);
            
            for (int i = 1; i <= raty; i++) {
                
            	allKwota = (float)((float)(((kwota + oplata) * (Math.pow((1 + (oprocentowanie / 12)), raty))) * ((1 + (oprocentowanie / 12)) - 1)) / (Math.pow(((1 + (oprocentowanie / 12))), (raty)) - 1));
                odsetki = allKwota - kapital;
                stringBuilder.append("<tr><th>Rata nr: " + i + "</th><th>" 
                + "Kwota kapitalu: " + Math.ceil(kapital) + "</th><th>" 
                + "Kwota odsetek: " + Math.ceil(odsetki) + "</th><th>"
                + "Oplata stala: " + oplata + "</th><th>"
                + "Calkowita rata: " + Math.ceil(allKwota) 
                + "</th></tr>");
            }
            
            stringBuilder.append("</table>");       
            } 

        return stringBuilder.toString();
        
    }

private void generatePdf(String html, HttpServletResponse response) throws IOException {

	String pre = "<!DOCTYPE html><html><head><title>Harmonogram rat</title></head><body><center><h1>Harmonogram rat</h1></center>";
	String post = "</body></html>";
	html = pre + html + post;
	
	response.setHeader("Cache-Control", "no-cache");
	response.setContentType("application/pdf"); 
	response.setHeader("Content-Disposition", "attachment; filename=\"" + "Harmonogram rat.pdf\"");
	response.setHeader("Cache-Control", "no-cache");
	
	OutputStream os = response.getOutputStream();
	final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	documentBuilderFactory.setValidating(true);
	DocumentBuilder builder;
	try {
	    builder = documentBuilderFactory.newDocumentBuilder();
	    builder.setEntityResolver(FSEntityResolver.instance());
	    org.w3c.dom.Document document;
	    document = builder.parse(new ByteArrayInputStream(html.getBytes())); 

	    ITextRenderer itxtrenderer = new ITextRenderer();
	    itxtrenderer.setDocument(document, null);
	    itxtrenderer.layout();
	    itxtrenderer.createPDF(os, true); 
	} catch (ParserConfigurationException e) {    	   
	    e.printStackTrace();

	} catch (SAXException e) {    	    
	    e.printStackTrace();
	} catch (DocumentException e) {
	    e.printStackTrace();
	}
	os.flush();
	os.close();
}
}
