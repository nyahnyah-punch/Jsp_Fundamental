<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file = "../inc/header.jsp" %>

<nav aria-label="breadcrumb">
		<ol class="breadcrumb justify-content-end">
			<li class="breadcrumb-item"><a href="#">Home</a></li>
			<li class="breadcrumb-item"><a href="#">Library</a></li>
			<li class="breadcrumb-item active" aria-current="page">Data</li>
		</ol>
	</nav>

	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<!-- form start -->
				<form>
					<div class="form-group">
						<label for="exampleFormControlInput1">Email address</label> <input
							type="email" class="form-control" id="exampleFormControlInput1"
							placeholder="name@example.com">
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Example select</label> <select
							class="form-control" id="exampleFormControlSelect1">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect2">Example multiple
							select</label> <select multiple class="form-control"
							id="exampleFormControlSelect2">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Example textarea</label>
						<textarea class="form-control" id="exampleFormControlTextarea1"
							rows="3"></textarea>
					</div>
				</form>
				<!-- form end -->
			</div>

		</div>
	</div>

<%@ include file = "../inc/footer.jsp" %>