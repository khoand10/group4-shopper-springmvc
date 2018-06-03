    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
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
		<section class="header_text sub"> <img class="pageBanner"
			src="/Shopper/themes/images/pageBanner.png" alt="New products">
		<h4>
			<span>Login or Regsiter</span>
		</h4>
		</section>
		<section class="main-content">
		<div class="row">
			<div class="span5">
				<h4 class="title">
					<span class="text"><strong>Login</strong> Form</span>
				</h4>
					${message}<br>
				<form action="check-login.htm" method="post">
					<input type="hidden" name="next" value="/">
					<fieldset>
						<div class="control-group">
							<label class="control-label">Username</label>
							<div class="controls">
								<input name="username" type="text" placeholder="Enter your username"
									id="username" class="input-xlarge">
										<form:errors path="username"/>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Password</label>
							<div class="controls">
								<input name="password" type="password" placeholder="Enter your password"
									id="password" class="input-xlarge">
									<form:errors path="password"/>
							</div>
						</div>
						<div class="control-group">
							<input tabindex="3" class="btn btn-inverse large" type="submit"
								value="Sign into your account">
							<hr>
							<p class="reset">
								Recover your <a tabindex="4" href="#"
									title="Recover your username or password">username or
									password</a>
							</p>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="span7">
				<h4 class="title">
					<span class="text"><strong>Register</strong> Form</span>
				</h4>
				<form action="register.htm" method="post" class="form-stacked">
					<fieldset>
						<div class="control-group">
							<label class="control-label">Username</label>
							<div class="controls">
								<input name="username" type="text" placeholder="Enter your username"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Email address:</label>
							<div class="controls">
								<input name="email" type="text" placeholder="Enter your email"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Password:</label>
							<div class="controls">
								<input name="password" type="password" placeholder="Enter your password"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Address:</label>
							<div class="controls">
								<input name="address" type="text" placeholder="Enter your address"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Phone:</label>
							<div class="controls">
								<input name="phone" type="text" placeholder="Enter your phone"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">FullName:</label>
							<div class="controls">
								<input name="fullname" type="text" placeholder="Enter your fullname"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Birthday:</label>
							<div class="controls">
								<input name="birthday" type="text" placeholder="Enter your birthday"
									class="input-xlarge">
							</div>
						</div>
						<div class="control-group">
							<p>Now that we know who you are. I'm not a mistake! In a
								comic, you know how you can tell who the arch-villain's going to
								be?</p>
						</div>
						<hr>
						<div class="actions">
							<input tabindex="9" class="btn btn-inverse large" type="submit"
								value="Create your account"><span style="font-size: 32px;color:red">${message }</span>
						</div>
					</fieldset>
				</form>
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
		<section id="copyright"> <span>Copyright 2013
			bootstrappage template All right reserved.</span> </section>
	</div>
	<script src="/Shopper/themes/js/common.js"></script>
	<script>
		$(document).ready(function() {
			$('#checkout').click(function(e) {
				document.location.href = "checkout.html";
			})
		});
	</script>