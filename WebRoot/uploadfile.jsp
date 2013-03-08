<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:fielderror />
	<s:url action="/struts2/uploadPhoto" var="uploadPhotoLink">
	</s:url>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare/test">
		<%-- 		<s:textfield name="photo.FCaption" label="Caption" />
		<s:file name="userImage" /> --%>
		<s:submit value="insertComment" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/PhotosGetInfoAction_getPopularPhotos">
		<s:submit value="getPopular" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/UploadFileAction">
		<s:hidden value="2" id="photo.uid" />
		<s:file value="Photo" id="photo.file" />
		<s:submit value="upload" />
	</s:form>
</body>
</html>