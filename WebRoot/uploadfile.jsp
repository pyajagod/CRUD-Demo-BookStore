
<%@ page language="java"%>
<%@ page contentType="text/html;charset=gb2312"%>
<html>
	<head>
		<title>�ļ��ϴ�</title>
	</head>
	<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="40"
		marginwidth="0" marginheight="0">
		<center>
			<h1>
				�ļ��ϴ�
			</h1>
			<form name="uploadform" method="POST"
				action=".\SaveUploadFile?isbn=<%=request.getParameter("isbn")%>"
				ENCTYPE="multipart/form-data">
				��ţ�<%=request.getParameter("isbn")%>
				<table border="3" width="450" cellpadding="4" cellspacing="2"
					bordercolor="#9BD7FF">
					<tr>
						<td width="40%">
							����ͼƬ�ļ���
						</td>
						<td>
							<input name="file1" size="30" type="file">
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" name="submit" value="��ʼ�ϴ�" />
						</td>
					</tr>
				</table>
			</form>
		</center>

	</body>
</html>
