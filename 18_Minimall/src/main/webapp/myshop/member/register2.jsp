<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
myshop-member-register.jsp<br>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
<style type="text/css">
 table{
  margin : auto
 }
 
 th{
  background-color : yellow;
 }
 
 th[colspan='2']{
  background-color : #ffcc00;
 }
 
 tr{
  height : 30px;
 }
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/script.js"></script>

<form action="registerProc.jsp" method="post" onSubmit="return writeSave()">
 <table border="1">
  <tr>
   <th colspan="2" bgcolor="#ffcc00">기본 정보</th>
  </tr>
  <tr>
   <th>* 회원 아이디</th>
   <td>
   <input type="text" name="id" onkeydown="keyd()">
   <input type="button" value="중복체크" onClick="duplicate()">
   <span id="idmessage"></span>
   </td>
  </tr>
  
  <tr>
  
   <th>* 비밀번호</th>
   <td>
   <input type="text" name="password"  onBlur="return pwcheck()">
   <span>영문 소문자/숫자 조합 3~8자</span>
   </td>
  </tr>
  
  <tr>
   <th>* 비밀번호 확인</th>
   <td>
   <input type="text" name="password2" onKeyUp="pw2check()">
   <span id="pwmessage"></span>
   </td>
  </tr>
  
  <tr>
   <th>* E-Mail</th>
   <td>
   <input type="text" name="email" value="gildong@naver.com">
   </td>
  </tr>
  
  <tr>
   <th colspan="2" bgcolor="#ffcc00">개인 신상 정보</th>
  </tr>
  
  <tr>
   <th>한글 이름</th>
   <td>
   <input type="text" name="name" value="홍길동">
   성과 이름을 붙여주세요 (예)홍길동
   </td>
  </tr>
  
  <tr>
   <th>주민 등록 번호</th>
   <td>
   <input type="text" name="rrn1" maxlength="6" value="123456"> - 
   <input type="text" name="rrn2" maxlength="7" value="1234567">
   </td>
  </tr>
  
  <tr>
   <th>휴대 전화 번호</th>
   <td>
    <select name="hp1">
     <option value="010">010</option>
     <option value="011">011</option>
    </select>
    -
    <input type="text" name="hp2" maxlength="4" value="1234">
    -
    <input type="text" name="hp3" maxlength="4" value="5678">
    예)011-000-0000
   </td>
  </tr>
  
  <tr>
   <th>가입 일자</th>
   <td>
    <input type="text" name="joindate" value="2020/01/01">
    예)2000/05/22
   </td>
  </tr>
  
  <tr>
   <th colspan="2" bgcolor="#ffcc00">
    <input type="submit" value="가입하기">
    <input type="reset" value="취소">
   </th>
  </tr>
  
 
 </table>


</form>