<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
String username=(String)session.getAttribute("LOGGED_IN_USER");
%>
<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Waste Management</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
					
						
					
				<li class="nav-item"><a class="nav-link"
					href="TypeOfRecidency.jsp">Recidency Types</a></li>
				<li class="nav-item"><a class="nav-link"
					href="displayRecidencyTypes.jsp">Recidency Details</a></li>
					
				
					
                    
			</ul>
			<%
			if(username==null) {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="Login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Register</a>
				</li>
			</ul>
			<%} else { %>
			
					<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
					href="#">Welcome <%=username %></a></li>
					
				<li class="nav-item active"><a class="nav-link"
					href="AdminLogout">Logout</a></li>
					</ul>
					<%} %>
		</div>
	</nav>
</header>