<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="panelwrap">
  	
<jsp:include page="top-menu.jsp"></jsp:include>
    
          
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    <h2>Tables section</h2> 
                    
                    
<table id="rounded-corner">
    <thead>
    	<tr>
        	<th></th>
            <th>ID Product</th>
            <th>Name</th>
            <th>Fabrication</th>
            <th>color</th>
            <th>images</th>
            <th>depcriptions</th>
            <th>amount</th>
            <th>UnitPrice</th>
            <th>DisCount</th>
            <th>DisCount</th>
        </tr>
    </thead>
        <tfoot>
    	<tr>
        	<td colspan="12">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</td>
        </tr>
    </tfoot>
    <tbody>
    	<c:forEach var="pro" items="${listproduct }">
    	<tr class="odd">
        	<td><input type="checkbox" name="" /></td>
            <td>${pro.id_product}</td>
            <td>${pro.productname}</td>
            <td>${pro.fabrication}</td>
            <td>${pro.color}</td>
            <td>${pro.images}</td>
            <td>${pro.depcriptions}</td>
            <td>${pro.amount}</td>
            <td>${pro.unitprice}</td>
            <td>${pro.discount}</td>            
            <td><a href="editpro/${pro.id_product}.htm"><img src="/Shopper/images/edit.png" alt="" title="" border="0" /></a></td>
            <td><a href="deletepro/${pro.id_product}.htm"><img src="/Shopper/images/trash.gif" alt="" title="" border="0" /></a></td>
        </tr>
    	</c:forEach>
    </tbody>
</table>
    
    <ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">Form Design Structure</a></li>
        <li><a href="#tab2">Tab two</a></li>
        <li><a href="#tab3">Tab three</a></li>
        <li><a href="#tab4">Tab four</a></li>
    </ul>
    <div id="tab1" class="tabcontent">
        <h3>Tab one title</h3>
        <div class="form">
           <form:form  method="post" modelAttribute="product_input" action="/Shopper/home/admin/addpro.htm">
           		<table>
			<tr>
				<th colspan="2">Add Product</th>
			</tr>
			<tr>
				<td><form:label path="id_product">ID Product:</form:label></td>
				<td><form:input path="id_product" size="10" maxlength="10"></form:input></td>
			</tr>
				<td><form:label path="productname">Name:</form:label></td>
				<td><form:input path="productname" size="30" maxlength="30"></form:input></td>
			</tr>
						<tr>
				<td><form:label path="fabrication">Fabrication:</form:label></td>
				<td><form:input path="fabrication" size="30" maxlength="30"></form:input></td>
			<tr>
						<tr>
				<td><form:label path="color">Color:</form:label></td>
				<td><form:input path="color" size="30" maxlength="30"></form:input></td>
			<tr>
			<tr>
				<td><form:label path="images">Images:</form:label></td>
				<td><form:input path="images" size="30" maxlength="30"></form:input></td>
			<tr>
			<tr>
				<td><input name="link" type="file" maxlength="30" /></td>
			</tr>
			
						<tr>
				<td><form:label path="depcriptions">Depcriptions:</form:label></td>
				<td><form:input path="depcriptions" size="30" maxlength="30"></form:input></td>
			<tr>
							<tr>
				<td><form:label path="amount">Amount:</form:label></td>
				<td><form:input path="amount" size="30" maxlength="30"></form:input></td>
			<tr>
							<tr>
				<td><form:label path="unitprice">Unitprice:</form:label></td>
				<td><form:input path="unitprice" size="30" maxlength="30"></form:input></td>
			<tr>
							<tr>
				<td><form:label path="discount">Discount:</form:label></td>
				<td><form:input path="discount" size="30" maxlength="30"></form:input></td>
			<tr>
			<tr>
				<td><form:select itemLabel="name_category" itemValue="id_category" path="category" items="${listCate }" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
		<br>
           </form:form>
           
        </div>
    </div>
    <div id="tab2" class="tabcontent">
        <h3>Tab two title</h3>
        <ul class="lists">
        <li>Consectetur adipisicing elit  error sit voluptatem accusantium doloremqu sed</li>
        <li>Sed do eiusmod tempor incididunt</li>
        <li>Ut enim ad minim veniam is iste natus error sit</li>
        <li>Consectetur adipisicing elit sed</li>
        <li>Sed do eiusmod tempor  error sit voluptatem accus antium dolor emqu incididunt</li>
        <li>Ut enim ad minim veniam</li>
        <li>Consectetur adipisi  error sit voluptatem accusantium doloremqu cing elit sed</li>
        <li>Sed do eiusmod tempor in is iste natus error sit cididunt</li>
        <li>Ut enim ad minim ve is iste natus error sitniam</li>
        </ul>
    </div>

    <div id="tab3" class="tabcontent">
        <h3>Tab three title</h3>
        <p>
    Lorem ipsum <a href="#">dolor sit amet</a>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. <br /><br />Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
        </p>
    </div> 
    
    <div id="tab4" class="tabcontent">
        <h3>Tab four title</h3>
        <p>
    Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, ad <br /><br />Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?
        </p>
    </div> 
     
    

    
        <div class="toogle_wrap">
            <div class="trigger"><a href="#">Toggle with text</a></div>

            <div class="toggle_container">
			<p>
        Lorem ipsum <a href="#">dolor sit amet</a>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.Lorem ipsum <a href="#">dolor sit amet</a>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			</p>
            </div>
        </div>
      
     </div>
     </div><!-- end of right content-->
                     
                    
    <div class="sidebar" id="sidebar">
               
    
    
    <div class="clear"></div>
    </div> <!--end of center_content-->
    
    <div class="footer">
Template By <a href="https://themefurnace.com/free-templates" rel="designer">ThemeFurnace</a>
</div>

</div>
