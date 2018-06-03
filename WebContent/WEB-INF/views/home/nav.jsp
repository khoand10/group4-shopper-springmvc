<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<a href="index.htm" class="logo pull-left"><img
			src="/Shopper/themes/images/logo.png" class="site_logo" alt=""></a>
		<nav id="menu" class="pull-right">
			<ul>
				<li><a href="./products.html">Woman</a>
					<ul>

						<li><a href="product_category.htm?id_category=${sessionScope.listCategory[0].id_category}">${sessionScope.listCategory[0].name_category }</a></li>
						<li><a href="product_category.htm?id_category=${sessionScope.listCategory[1].id_category}">${sessionScope.listCategory[1].name_category }</a></li>
					</ul></li>
				<li><a href="product_bestSeller.htm">Best Sales</a></li>
			</ul>
		</nav>
	</div>
</section>