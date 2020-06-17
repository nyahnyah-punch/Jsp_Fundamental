<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
   integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
   crossorigin="anonymous">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/js/jquery-3.5.1"></script>
<script
   src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
   integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
   crossorigin="anonymous"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
   integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
   crossorigin="anonymous"></script>

<!-- 검색창 시작 -->
<div class="container">
   <div class="row" style="margin: 50px 0px 60px;">
      <div class="col-sm-12">
         <h5 class="card-title">응급실 현황 검색</h5>
         <div class="form-row d-flex align-items-center">
            <div class="form-group col-md-10">
               <input type="text" id="address" name="address" class="form-control"
                  placeholder="주소를 입력하세요." />
            </div>
            <div class="form-group col-sm-2">
               <a href="resultPage.jsp" id="search" class="btn btn-outline-primary">
                  <i class="fa fa-search" aria-hidden="true"></i> 검색 </a>
            </div>
         </div>
      </div>
   </div>
   <!-- 검색창 끝 -->