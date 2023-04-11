<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_MEMBERLIST.jsp -->
<jsp:include page="AD_TOP.jsp"/>
    <!-- Page Content-->
    <h1 class="mb-5 mt-5 text-center">회원 목록</h1>
    <table class="table">
  		<thead>
    		<tr>
      			<th scope="col">#</th>
      			<th scope="col">First</th>
      			<th scope="col">Last</th>
      			<th scope="col">Handle</th>
    		</tr>
  		</thead>
  		<tbody>
    		<tr>
      			<th scope="row">1</th>
      			<td>Mark</td>
      			<td>Otto</td>
      			<td>@mdo</td>
    		</tr>
  		</tbody>
	</table>
                        <!-- quick menu -->
                        <div class="col-xl-4 quickmenu">
                            <div class="card border-0 bg-light mt-xl-5">
                                <div class="card-body p-4 py-lg-5">
                                    <div class="d-flex align-items-center justify-content-center">
                                        <div class="text-center">
                                            <div class="h6 fw-bolder">원하시는 작업을 선택하세요.</div>
                                            <div class="d-grid gap-2 d-md-block">
  												<button class="btn btn-warning" type="button">수정하기</button>
  												<button class="btn btn-danger" type="button">삭제하기</button>
											</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>