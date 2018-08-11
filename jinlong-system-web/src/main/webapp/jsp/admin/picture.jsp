<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%
	String pictureFilePath = request.getParameter("pictureFilePath");
	pictureFilePath = java.net.URLDecoder.decode(pictureFilePath,"UTF-8");
	FileInputStream in = null;
	try {
		in = new FileInputStream(new File(pictureFilePath));
	} catch (Exception ex) {
		in = null;
	}
	if (in != null) {
		OutputStream o = response.getOutputStream();
		int l = 0;
		byte[] buffer = new byte[1024];
		while ((l = in.read(buffer)) != -1) {
			o.write(buffer, 0, l);
		}

		out.clear();
		out = pageContext.pushBody();

		o.flush();
		in.close();
		o.close();
	}
%>