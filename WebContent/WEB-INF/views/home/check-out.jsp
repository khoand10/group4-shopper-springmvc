<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="top-bar" class="container">
	<div class="row">
		<div class="span4">
			<form method="POST" class="search_form">
				<input type="text" class="input-block-level search-query"
					Placeholder="eg. T-sirt">
			</form>
		</div>
		<jsp:include page="top-menu.jsp"></jsp:include>
	</div>
</div>
<div id="wrapper" class="container">
	<jsp:include page="nav.jsp"></jsp:include>
	<section class="header_text sub">
		<img class="pageBanner" src="/Shopper/themes/images/pageBanner.png"
			alt="New products">
		<h4>
			<span>Check Out</span>
		</h4>
	</section>
	<section class="main-content">
		<div class="row">
			<div class="span12">
				<div class="accordion" id="accordion2">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#collapseOne">Product</a>
						</div>
						<div id="collapseOne" class="accordion-body in collapse">
							<div class="accordion-inner">
								<div class="row-fluid">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>Product Name</th>
												<th>Quantity</th>
												<th>Size</th>
												<th>Unit Price</th>
												<th>Total</th>
											</tr>
										</thead>
										<form action="cancle.htm" method="get">
											<c:forEach var="list" items="${list }">
												<tr>
													<td>${list.product.getProductname() }</td>
													<td><input type="text" placeholder="1"
														class="input-mini" value="${list.amount }"></td>
													<td>${list.size }</td>
													<td>$${list.moneys }</td>
													<td>$${list.moneys*list.amount }</td>
												</tr>
												<input type="hidden" name="Id_cancle"
													value="${list.getId_cartdetail()}" />

												<c:if test="${user.username==null}">
													<input type="hidden" name="Id_cart" value="2" />
												</c:if>
												<c:if test="${user.username!=null}">
													<input type="hidden" name="Id_cart"
														value="${user.carts[0].getId_cart() }" />
												</c:if>

											</c:forEach>
											<td><input type="submit" value="Huy"></td>
										</form>
									</table>
								</div>
								<strong>Total</strong>: $${total }<br>
							</div>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#collapseTwo">Account &amp;
								Billing Details</a>
						</div>
						<div id="collapseTwo" class="accordion-body collapse">
							<div class="accordion-inner">
								<div class="row-fluid">
									<div class="span6">
										<h4>Your Personal Details</h4>
										<form action="checkout.htm" method="post">
										<div class="control-group">
											<label class="control-label">UserName</label>
											<div class="controls">
												<input name="uname" type="text" placeholder="" class="input-xlarge"
													value="${user.username }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Email</label>
											<div class="controls">
												<input type="text" placeholder="" class="input-xlarge"
													value="${user.email }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Address</label>
											<div class="controls">
												<input name="address" type="text" placeholder="" class="input-xlarge"
													value="${user.address }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Phone</label>
											<div class="controls">
												<input name="phone" type="text" placeholder="" class="input-xlarge"
													value="${user.phone }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">FullName</label>
											<div class="controls">
												<input name="fullname" type="text" placeholder="" class="input-xlarge"
													value="${user.fullname }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Birthday</label>
											<div class="controls">
												<input type="text" placeholder="" class="input-xlarge"
													value="${user.birthday }">
											</div>
										</div>
								<div class="row-fluid">
										<div class="control-group">
											<label class="control-label">Notes</label>
											<div class="controls">
												<input name="notes" type="text" placeholder="" class="input-xlarge"
													value="">
											</div>
										</div>
										<c:forEach var="list" items="${list }">
										<input type="hidden" name="Id_cancle" value="${list.getId_cartdetail()}" />
										</c:forEach>
										<input name="total" type="hidden" value="${total }" />
										<input name="Id_cart" type="hidden" value="${Id_cart }" />
									<input type="submit" class="btn btn-inverse pull-right">Confirm order />
								</div>
										</form>
									</div>
								</div>
							</div>
						</div>
<!-- 					</div> -->
<!-- 					<div class="accordion-group"> -->
<!-- 						<div class="accordion-heading"> -->
<!-- 							<a class="accordion-toggle" data-toggle="collapse" -->
<!-- 								data-parent="#accordion2" href="#collapseThree">Confirm -->
<!-- 								Order</a> -->
<!-- 						</div> -->
<!-- 						<div id="collapseThree" class="accordion-body collapse"> -->
<!-- 							<div class="accordion-inner"> -->
<!-- 								<div class="row-fluid"> -->
<!-- 									<div class="control-group"> -->
<!-- 										<label for="textarea" class="control-label">Notes</label> -->
<!-- 										<div class="controls"> -->
<!-- 											<textarea rows="3" id="textarea" class="span12"></textarea> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 									<button class="btn btn-inverse pull-right">Confirm -->
<!-- 										order</button> -->
<!-- 								</div> -->
								
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
			</div>
		</div>
	</section>
	<section id="footer-bar">
		<div class="row">
			<div class="span3">
				<h4>Navigation</h4>
				<ul class="nav">
					<li><a href="./index.html">Homepage</a></li>
					<li><a href="./about.html">About Us</a></li>
					<li><a href="./contact.html">Contac Us</a></li>
					<li><a href="./cart.html">Your Cart</a></li>
					<li><a href="./register.html">Login</a></li>
				</ul>
			</div>
			<div class="span4">
				<h4>My Account</h4>
				<ul class="nav">
					<li><a href="#">My Account</a></li>
					<li><a href="#">Order History</a></li>
					<li><a href="#">Wish List</a></li>
					<li><a href="#">Newsletter</a></li>
				</ul>
			</div>
			<div class="span5">
				<p class="logo">
					<img src="themes/images/logo.png" class="site_logo" alt="">
				</p>
				<p>Lorem Ipsum is simply dummy text of the printing and
					typesetting industry. the Lorem Ipsum has been the industry's
					standard dummy text ever since the you.</p>
				<br /> <span class="social_icons"> <a class="facebook"
					href="#">Facebook</a> <a class="twitter" href="#">Twitter</a> <a
					class="skype" href="#">Skype</a> <a class="vimeo" href="#">Vimeo</a>
				</span>
			</div>
		</div>
	</section>
	<section id="copyright">
		<span>Copyright 2013 bootstrappage template All right reserved.</span>
	</section>
</div>
<script src="themes/js/common.js"></script>