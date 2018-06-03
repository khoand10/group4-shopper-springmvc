<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="span8">
	<div class="account pull-right">
		<ul class="user-menu">
			<li><a href="info.htm">My Acount</a></li>
			<li><a href="product_all.htm">Product</a></li>
			<c:if test="${user.username==null}">
				<li><a href="cart-info.htm?Id_cart=2">Your Cart</a></li>
			</c:if>
			<c:if test="${user.username!=null}">
				<li><a href="cart-info.htm?Id_cart=${user.carts[0].getId_cart() }">Your Cart</a></li>
			</c:if>
			<li><a href="willBuy.htm?Id_cart=${user.carts[0].getId_cart() }">Checkout</a></li>
			<li><a href="logout.htm">Logout</a></li>
			<c:if test="${user.username==null}">
				<li><a href="login.htm">Login</a></li>
			</c:if>
			<c:if test="${user.username!=null}">
				<li><a href="info.htm">${user.username }</a></li>
			</c:if>
		</ul>
	</div>
</div>