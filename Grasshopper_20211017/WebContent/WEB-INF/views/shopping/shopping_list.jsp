<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<div style="width: 80%; height: 90%; margin: 0 auto;">
	<div>
		
		<nav style="text-align:center;">
        	<ul>
            	<li><a href="/shopping/list?category=alchol">주류</a></li>
            	<li><a href="/shopping/list?category=tool">칵테일 도구</a></li>
            	<li><a href="/shopping/list?category=food">음식 재료</a></li>
        	</ul>   
    	</nav> 
    	
 

		<div style="height: 100%;">
			<div class="row" style="float: left;" id="list">
				<c:forEach items="${shoppingBoardList}" var="shoppingboard">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail" style="height: 430px;">
							<img src="${shoppingboard.shopping_img_link}"
								style="height: 201.31px;" />
							<div class="caption">
								<h3>${shoppingboard.shopping_product_title}</h3>
								<p>${shoppingboard.shopping_product_content}</p>
								<p>
									<a href="${shoppingboard.shopping_product_link}"
										class="btn btn-primary" role="button">구매사이트</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


</div>

