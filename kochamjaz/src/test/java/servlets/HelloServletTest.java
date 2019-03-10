package servlets;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

public class HelloServletTest extends Mockito {

	@Test
	public void servlet_if_kwota_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("kwota")).thenReturn(null);
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
		
	}

	@Test
	public void servlet_if_kwota_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("kwota")).thenReturn("");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
	}
	@Test
	public void servlet_if_raty_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("raty")).thenReturn(null);
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
		
	}

	@Test
	public void servlet_if_raty_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("raty")).thenReturn("");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
	}
	@Test
	public void servlet_if_oprocentowanie_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("oprocentowanie")).thenReturn(null);
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
		
	}

	@Test
	public void servlet_if_oprocentowanie_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("oprocentowanie")).thenReturn("");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
	}
	@Test
	public void servlet_if_oplata_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("oplata")).thenReturn(null);
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
		
	}

	@Test
	public void servlet_if_oplata_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("oplata")).thenReturn("");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
	}
	@Test
	public void servlet_if_sel_is_null() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("sel")).thenReturn(null);
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
		
	}

	@Test
	public void servlet_if_sel_is_empty() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = mock(PrintWriter.class);
		when(response.getWriter()).thenReturn(writer);
		HelloServlet servlet = new HelloServlet();
		when(request.getParameter("sel")).thenReturn("");
		servlet.doPost(request, response);
		verify(response).sendRedirect("/");
	}
}
