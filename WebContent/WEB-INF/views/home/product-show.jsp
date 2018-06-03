<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Feature <strong>Products</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails">	
											<%-- load 4 san pham cho hàng 1 --%>
											<c:forEach var="pro1" items="${product1}">						
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="product_detail.htm?id_product=${pro1.id_product }"><img src="${pro1.images}" alt="" /></a></p>
 														<a href="product_detail.htm?id_product=${pro1.id_product }" class="title">${pro1.productname }</a><br/> 
														<a href="product_category.htm?id_category=${pro1.category.getId_category() }" class="category">${pro1.category.getName_category() }</a>
														<p class="price">$${pro1.unitprice-pro1.discount}</p>
													</div>
												</li> 
											</c:forEach>	
											</ul>
											</div>
										<div class="item">
										<ul class="thumbnails">
										<%-- load 4 san pham cho hàng 2 --%>
										<c:forEach var="pro2" items="${product2 }">
										<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.htm?id_product=${pro2.id_product }"><img src="${pro2.images}" alt="" /></a></p>
														<a href="product_detail.htm?id_product=${pro2.id_product }" class="title">${pro2.productname }</a><br/>
														<a href="product_category.htm?id_category=${pro2.category.getId_category() }" class="category">${pro2.category.getName_category() }</a>
														<p class="price">$${pro2.unitprice-pro1.discount}</p>
													</div>
												</li>
										</c:forEach>
																																							
											</ul>
										</div>
									</div>											
						</div>
						<br/>
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Latest <strong>Products</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-2" data-slide="prev"></a><a class="right button" href="#myCarousel-2" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-2" class="myCarousel carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails">												
												<c:forEach var="pro3" items="${product3 }">
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="product_detail.htm?id_product=${pro3.id_product }"><img src="${pro3.images }" alt="" /></a></p>
														<a href="product_detail.htm?id_product=${pro3.id_product }" class="title">${pro3.productname }</a><br/>
														<a href="product_category.htm?id_category=${pro3.category.getId_category() }" class="category">${pro3.category.getName_category() }</a>
														<p class="price">$${pro3.unitprice-pro3.discount }</p>
													</div>
												</li>
												</c:forEach>
											</ul><% %>
										</div>
										<div class="item">
											<ul class="thumbnails">
											<c:forEach var="pro4" items="${product4 }">
											<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.htm?id_product=${pro4.id_product }"><img src="${pro4.images }" alt="" /></a></p>
														<a href="product_detail.htm?id_product=${pro4.id_product }" class="title">${pro4.productname }</a><br/>
														<a href="product_category.htm?id_category=${pro4.category.getId_category() }" class="category">${pro4.category.getName_category() }</a>
														<p class="price">$${pro4.unitprice-pro4.discount }</p>
													</div>
												</li>
											</c:forEach>																																	
											</ul>
										</div>
									</div>							
								</div>
							</div>						
						</div>