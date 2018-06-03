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
<!-- 			<span>Check Out</span> -->
		</h4>
	</section>
	<section class="main-content">
		<div class="row">
			<div class="span12">
				<h2>${message }</h2><br>
				<a href="index.htm">Return index</a>
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