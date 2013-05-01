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
		action="/photoShare-mobile/CommentAction">
		<%-- 		<s:textfield name="photo.FCaption" label="Caption" />
		<s:file name="userImage" /> --%>
		<s:submit value="insertComment" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/PhotosGetInfoAction_getPopularPhotos">
		<s:submit value="getPopular" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/uploadPhoto">
		<s:textfield name="uid" />
		<s:file value="Photo" name="image" />
		<s:submit value="upload" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/UserHome_getOtherProfile">
		<s:textfield name="userInfo.uid" />
		<s:textfield name="userInfo.fid" />
		<s:submit value="upload" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/UserHome_getUserProfile">
		<s:textfield name="userInfo.uid" />
		<s:submit value="upload" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/FollowGetInfoAction_getFollowerInfo">
		<s:textfield name="userInfo.uid" />
		<s:submit value="getFollowerInfo" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/FollowGetInfoAction_getFollowingInfo">
		<s:textfield name="userInfo.uid" />
		<s:submit value="getFollowingInfo" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/CommentGetInfoAction">
		<s:textfield name="comment.pid" />
		<s:submit value="CommentGetInfoAction" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/PhotosGetInfoAction_getUserPhotos">
		<s:textfield name="userInfo.uid" />
		<s:submit value="UserPhotosGetInfoAction" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/BaseNewsAction_getFollowingNews">
		<s:textfield name="uid" />
		<s:textfield name="datediff" />
		<s:submit value="UserNewsGetInfoAction" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/BaseNewsAction_getUserNews">
		<s:textfield name="uid" />
		<s:textfield name="datediff" />
		<s:submit value="UserNewsGetInfoAction" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/CommentGetInfoAction_getCommentInfo">
		<s:textfield name="comment.pid" />
		<s:submit value="CommentGetInfo" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/CommentGetInfoAction_getCommentInfoByDatediff">
		<s:textfield name="comment.pid" />
		<s:textfield name="datediff" />
		<s:submit value="CommentGetInfoByDate" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/FollowGetInfoAction_getFollowingInfoByDatediff">
		<s:textfield name="userInfo.uid" />
		<s:textfield name="datediff" />
		<s:submit value="FollowingGetInfoByDate" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/FollowGetInfoAction_getFollowerInfoByDatediff">
		<s:textfield name="userInfo.uid" />
		<s:textfield name="datediff" />
		<s:submit value="FollowerGetInfoByDate" />
	</s:form>

	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/LikeGetInfoAction_getLikeInfo">
		<s:textfield name="like.pid" />
		<s:submit value="LikeGetInfo" />
	</s:form>
	
	<s:form method="post" enctype="multipart/form-data"
		action="/photoShare-mobile/LikeGetInfoAction_getLikeInfoByDatediff">
		<s:textfield name="like.pid" />
		<s:textfield name="datediff"/>
		<s:submit value="LikeGetInfoByDate" />
	</s:form>

</body>
</html>