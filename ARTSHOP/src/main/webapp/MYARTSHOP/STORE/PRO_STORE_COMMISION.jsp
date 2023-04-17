<%@page import="ARTSHOP.PRODUCT.PRODUCTDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PRO_STORE_COMMISION.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
	ArrayList<PRODUCTDTO> lists = pdao.getAllProduct();
%>


<jsp:include page="<%=request.getContextPath() %>/MYARTSHOP/PRODUCT/PRO_TOP.jsp"/>
<!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">COMMISION</h1>
                    <p class="lead fw-normal text-white-50 mb-0">상업적 이용 불가 상품</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                	<%for(int i=0;i<lists.size();i++){
                		String cat = lists.get(i).getProcat();
                		if(cat.contains("커미션")){%>
                    		<div class="col mb-5"><!-- 카드 시작 -->
                    			<div class="col mb-5">
                        		<div class="card h-50">
                           		<!-- Product details-->
                                	<div class="text-center m-4">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder mt-2"><%=lists.get(i).getProsub() %></h5>
                                    <!-- Product price-->
                                    <%=lists.get(i).getPropri() %>
                                	</div>
                            		<!-- Product actions-->
                            		<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center">
                                	<a class="btn btn-outline-dark mt-auto" href="LOGIN.jsp">주문하기</a> 
                                	<a class="btn btn-outline-dark mt-auto" href="<%=request.getContextPath() %>/MYARTSHOP/PRODUCT/PRO_DETAIL.jsp">상세보기</a>
                                	</div>
                            		</div>
                        		</div>
                    			</div>
                    		</div><!-- 카드 끝 -->
                    <%}
                    	}%>
                </div>
            </div>
        </section>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>