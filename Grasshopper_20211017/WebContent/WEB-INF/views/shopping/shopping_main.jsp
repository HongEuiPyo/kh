<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<div style="width: 70%; height: 100%; margin: 0 auto;">
	<div class="row">
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img
					src="https://images.pexels.com/photos/1283219/pexels-photo-1283219.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
					style="height: 201.31px;" />
				<div class="caption">
					<h3>주류 목록</h3>
					<p>칵테일에 사용되는 각종 주류들을 보러갑니다</p>
					<p>
						<a href="/shopping/list?category=alchol" class="btn btn-primary"
							role="button">목록 보기</a>
				</div>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img
					src="https://images.pexels.com/photos/2611814/pexels-photo-2611814.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
					style="height: 201.31px;" />
				<div class="caption">
					<h3>칵테일 도구</h3>
					<p>칵테일을 만드는데 필요한 각종 도구들을 보러갑니다</p>
					<p>
						<a href="/shopping/list?category=tool" class="btn btn-primary" role="button">목록 보기</a> 
					</p>
				</div>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img
					src="https://images.pexels.com/photos/3596688/pexels-photo-3596688.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
					style="height: 201.31px;" />
				<div class="caption">
					<h3>음식</h3>
					<p>칵테일과 함께먹기 좋은 음식들을 보러 갑니다</p>
					<p>
						<a href="/shopping/list?category=food" class="btn btn-primary" role="button">목록 보기</a> 
					</p>
				</div>
			</div>
		</div>
		
	</div>

</div>

<c:import url="/WEB-INF/views/layout/footer.jsp"/>

