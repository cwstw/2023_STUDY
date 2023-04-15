<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- ARTSHOP_MAIN_TOP.jsp -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="커미션, 외주 플랫폼 아트샵 artshop" />
        <meta name="author" content="cwstw" />
        <title>ART#</title>
        <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <script src="<%=request.getContextPath()%>/ARTSHOP_SCRIPT.js"></script>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath() %>/MYARTSHOP/IMAGES/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath() %>/css/styles.css" rel="stylesheet" />
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="<%=request.getContextPath() %>/ARTSHOP_MAIN.jsp">ART#</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="AD_MAIN.jsp">홈</a></li>
                            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/MYARTSHOP/ADMIN/AD_MEMBERLIST.jsp">회원관리</a></li>
                            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/MYARTSHOP/ADMIN/AD_PRODUCTLIST.jsp">상품관리</a></li>
                            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/MYARTSHOP/ADMIN/AD_ORDERLIST.jsp">주문관리</a></li>
                            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/MYARTSHOP/BOARD/BOARDLIST.jsp">문의게시판</a></li>
                            <li class="nav-item"><a class="nav-link" href="<%=request.getContextPath() %>/MYARTSHOP/MEMBER/GN_MAIN.jsp">사용자홈</a></li>
                            <!-- <li class="nav-item"><a class="nav-link" href="BOARD_LIST.jsp">문의게시판</a></li> -->
                        </ul>
                    </div>
                </div>
            </nav>