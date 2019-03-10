<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="hello" method="post">
<table border="1">
<tr><th>Wnioskowana kwota kredytu:</th><th><input type="number" id="kwota" name="kwota"/></th></tr>
<tr><th>Ilosc rat:</th><th><input type="number" id="raty" name="raty"/></th></tr>
<tr><th>Oprocentowanie:</th><th><input type="number" id="oprocentowanie" name="oprocentowanie"/></th></tr>
<tr><th>Oplata stala:</th><th><input type="number" id="oplata" name="oplata"/></th></tr>
<tr><th>Rata:</th><th><select id="sel" name="sel">
<option value="stala">stala</option>
<option value="malejaca">malejaca</option>
</select></th></tr>
</table>
<input type="submit" value="Wyslij"/>
</form>
</body>
</html>