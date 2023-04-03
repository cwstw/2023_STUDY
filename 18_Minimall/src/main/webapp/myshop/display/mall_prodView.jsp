<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">	
<!-- mall.jsp(pnum) => mall_prodView.jsp -->
<script>
	function goCart(pnum){
		oqty = document.f.oqty.value;
		//alert(oqty);
		if(oqty < 1){
			alert('ì£¼ë¬¸ìëì 1ë³´ë¤ í¬ê±°ë ê°ìì¼ í©ëë¤.');
			return;
		}
		location.href = "<%=request.getContextPath()%>/myshop/display/mall_cartAdd.jsp?pnum="+pnum+"&oqty="+oqty;
	}//gocart
	
	function goOrder(pnum){
		document.f.action="mall_order.jsp?pnum="+pnum;//폼 액션설정 여기서도 가능
		document.f.submit();//서브밋 누른 것 처럼 실행
	}
</script>
<%
	//새로고침 시 수량 반복 추가 방지
	//ServletContext application = new ServletContext();
	//application 내장 객체 : 프로젝트당 하나만 만들어짐
	//프로젝트 전반에 걸쳐 단 한번만 사용하려면 어플리케이션 속성으로 추가
	//application.setAttribute(속성명, 값);
	application.setAttribute("flag", true);

	String pnum = request.getParameter("pnum");
	ProductDAO pdao = ProductDAO.getInstance();
	ProductBean pb = pdao.getProductByPnum(pnum);
	DecimalFormat df = new DecimalFormat("###,###");
	
	String imgPath = request.getContextPath()+"/myshop/images/"+pb.getPimage();
%>
<table border="0" class="outline">
	<tr align="center">
		<th colspan="2">[<%=pb.getPname() %>] ìí ì ë³´</th>
	</tr>
	<tr>
		<td><img src="<%=imgPath %>" width="80" height="40"></td>
		<td>
			<form name="f" method="post">
			ìíë²í¸ : <%=pnum %><br>
			ìíì´ë¦ : <%=pb.getPname() %><br>
			ìíê°ê²© : <font color="red"><strong><%=df.format(pb.getPrice()) %></strong></font>ì<br>
			ìíí¬ì¸í¸ : <font color="red"><strong>[<%=df.format(pb.getPoint()) %>]</strong></font>point<br>
			ìíê°¯ì : <input type="text" name="oqty" size="2" value="1">ê°<br><br>
			<table width="90%" align="center">
				<tr>
					<td><a href="javascript:goCart('<%=pnum%>')"><img src="<%=request.getContextPath()%>/myshop/images/cartbtn.gif" width="90" height="30"></a></td>
					<td><a href="javascript:goOrder('<%=pnum%>')"><img src="<%=request.getContextPath()%>/myshop/images/orderbtn.gif" width="90" height="30"></a></td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
	<tr width="200" align="top">
		<td colspan="2">
			<b>ìí ìì¸ì¤ëª</b><br>
			<%=pb.getPcontents() %>
		</td>
	</tr>
</table>
<jsp:include page="mall_bottom.jsp"/>