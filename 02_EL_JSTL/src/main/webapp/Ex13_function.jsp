<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>함수 사용</title>
</head>  
<body>
<c:set var="str1" value="      Functions <태그>를 사용합니다." />
<c:set var="str2" value="사용" /> 
<c:set var="tokens" value="1,2,3,4,5,6,7,8,9,10" />

str1 = ${str1 }<br><br> 
tokens = ${tokens }<br><br>
length(str1) = ${fn:length(str1)} <br><br> 
toUpperCase(str1) = "${fn:toUpperCase(str1)}" <br><br>
toLowerCase(str1) = "${fn:toLowerCase(str1)}" <br><br>
substring(str1, 7, 10) = "${fn:substring(str1, 7, 10)}" <br><br> <!-- 문자열 일부를 가져옴. 0부터 -->
substringAfter(str1, str2) = "${fn:substringAfter(str1, str2)}" <br><br>  <!-- str2의 뒤부터 가져옴 -->
substringBefore(str1, str2) = "${fn:substringBefore(str1, str2)}" <br><br>
trim(str1) = "${fn:trim(str1)}" <br><br> <!-- 공백 제외 -->
length(trim(str1)) = "${fn:length(fn:trim(str1))}" <br><br> <!-- 함수안에 함수 사용 가능, 트림한 글자수 출력 -->
replace(str1, src, dest) = "${fn:replace(str1, " ", "-")}" <br><br> <!-- 공백을 -로 대체 -->
indexOf(str1, str2) = "${fn:indexOf(str1, str2)}" <br><br> <!-- str2가 몇번째 있는지 출력 -->  
startsWith(str1, str2) = "${fn:startsWith(str1, 'Fun')}" <br><br> <!-- fun으로 시작하면 true -->
endsWith(str1, str2) = "${fn:endsWith(str1, "합니다.")}" <br><br> <!-- 합니다로 끝나면 true -->
contains(str1, str2) = "${fn:contains(str1, str2)}" <br><br> <!-- 포함되면 true -->
containsIgnoreCase(str1, str2) = "${fn:containsIgnoreCase(str1, str2)}" <br><br> <!-- 대소문자 무시하고 포함되면 true -->

<c:set var="array" value="${fn:split(tokens, ',')}" />
\${array } : ${array } <!-- 쉼표를 기준으로 나뉨 -->
<c:set var="total" value="0" /> 
<c:set var="arrlen" value="${fn:length(array)}"/>

<c:forEach var="i" begin="0" end="${arrlen-1}" step="1">
	<c:out value="${array[i]}" /> 
</c:forEach>
<br><br>

<c:forEach var="i" begin="0" end="${arrlen-1}" step="1">
	<c:set var="total" value="${total + array[i]}" />
</c:forEach>

총합 : <c:out value="${total}" /><br><br>

array의 길이 : length(array) = ${fn:length(array)} <br><br> <!-- 10 -->
join(array, "-") = "${fn:join(array, "-")}" <br><br>


</body>
</html>

