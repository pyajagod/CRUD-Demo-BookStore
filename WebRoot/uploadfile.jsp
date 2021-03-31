
<%@ page language="java"%>
<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>文件上传</title>
	</head>
	<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="40"
		marginwidth="0" marginheight="0">
		<center>
			<h1>
				文件上传
			</h1>
			<form name="uploadform" method="POST"
				action=".\SaveUploadFile?isbn=<%=request.getParameter("isbn")%>"
				ENCTYPE="multipart/form-data">
				书号：<%=request.getParameter("isbn")%>
				<table border="3" width="450" cellpadding="4" cellspacing="2"
					bordercolor="#9BD7FF">
					<tr>
						<td width="40%">
							封面图片文件：
						</td>
						<td>
							<input name="file1" size="30" type="file">
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" name="submit" value="开始上传" />
						</td>
					</tr>
				</table>
			</form>
		</center>

	</body>
</html>
