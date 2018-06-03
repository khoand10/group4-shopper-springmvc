<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="panelwrap">
  	
	<div class="header">
    <div class="title"><a href="#">Panelo Admin</a></div>
    
    <div class="header_right">Welcome Admin, <a href="#" class="settings">Settings</a> <a href="#" class="logout">Logout</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="#" class="selected">Main page</a></li>
    <li><a href="#">Settings</a></li>
    <li><a href="#">Add a category</a></li>
    </ul>
    </div>
    
    </div>          
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
    <h2>Login</h2> 
                    

    <div id="tab1" class="tabcontent">
        <h3>Tab one title</h3>
        <div class="form">
           <form:form  method="post" modelAttribute="userdetail" action="/Shopper/home/admin/check-login-admin.htm">
           		<table>
			<tr>
				<th colspan="2">Login</th>
			</tr>
			<tr>
				<td><label>UserName</label></td>
				<td><input name="username" type="text" size="30" maxlength="30" /></td>
			</tr>
				<td><label>PassWord</label></td>
				<td><input name="password" type="password" size="30" maxlength="30" /></td>
			</tr>
			<tr>
				<td colspan="2"><input value="login" type="submit" class="blue-button" /></td>
			</tr>
		</table>
		<br>
           </form:form>
           
        </div>
    </div>
    <!--end of center_content-->
    
    <div class="footer">
Template By <a href="https://themefurnace.com/free-templates" rel="designer">ThemeFurnace</a>
</div>

</div>
