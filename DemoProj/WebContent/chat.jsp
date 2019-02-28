<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
</head>
<style>
div.stars {
  width: 300px;
  display: inline-block;

}
 input.star { display: none; }
 
label.star {

  float: right;
  padding: 10px;
  font-size: 36px;
  color: #444;
  transition: all .2s;
}

input.star:checked ~ label.star:before {
  content: '\f005';
  color: #FD4;
  transition: all .25s;
}

input.star-5:checked ~ label.star:before {
  color: #FE7;
  text-shadow: 0 0 20px #952;
}

 input.star-1:checked ~ label.star:before { color: #F62; } 

/* label.star:hover { transform: rotate(-15deg) scale(1.3); }
 */
label.star:before {
  content: '\f006';
  font-family: FontAwesome;
} 
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: white;
  color: black;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}




/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}


</style>
<body>

      
 <div class="item active">
        <img src="chat.jpg" alt="New York" width="1250" height="250">
 </div>
 <br>
 <div class="container">
<div class="row">
    <div class="col-sm-6">
    <br>
     
      <iframe width="500" height="400" src="https://www.youtube.com/embed/I4wmMkobKAg" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
  </div> 
  <div class="col-sm-6">
  <br>
  	<p class="text-center"><strong><h3>Details</h3></strong><br>The Beginning is a 2015 Indian epic action film directed by S. S. Rajamouli. The film was produced by Shobu Yarlagadda and Prasad Devineni and was shot in both Telugu and Tamil. This film was also dubbed into Malayalam and Hindi. The film stars Prabhas, Rana Daggubati, Anushka Shetty, and Tamannaah in the lead roles, with Ramya Krishnan, Sathyaraj, and Nassar in supporting roles. </p>
  <% if(session.getAttribute("user")==null){
  		%>
  	<form method="get" action="login.jsp">
  		<button>
  	
	  	<div class="stars">
		    <input class="star star-5" id="star-5" value="5" type="radio" name="star" disabled/>
		
		    <label class="star star-5" for="star-5"></label>
		
		    <input class="star star-4" id="star-4" value="4" type="radio" name="star" disabled/>
		
		    <label class="star star-4" for="star-4"></label>
		
		    <input class="star star-3" id="star-3" value="3" type="radio" name="star" disabled />
		
		    <label class="star star-3" for="star-3"></label>
		
		    <input class="star star-2" id="star-2" value="2" type="radio" name="star" disabled/>
		
		    <label class="star star-2" for="star-2"></label>
		
		    <input class="star star-1" id="star-1" value="1" type="radio" name="star" disabled />
		
		    <label class="star star-1" for="star-1"></label>
	    </div>
	    <div>
	    	Comments:<input name="comments" id="comments" disabled/>
	    </div>
	    <!-- <input type="submit"  value="Login"/> -->
	  </button>
  </form> 
	
  <%} else{%>
  	<form method="post" action="RatingServlet">
 
	  <%session.setAttribute("user",null); %>
  		<h3>Rating:</h3>
	  	<div class="stars">
		    <input class="star star-5" id="star-5" value="5" type="radio" name="star" />
		
		    <label class="star star-5" for="star-5"></label>
		
		    <input class="star star-4" id="star-4" value="4" type="radio" name="star" />
		
		    <label class="star star-4" for="star-4"></label>
		
		    <input class="star star-3" id="star-3" value="3" type="radio" name="star" />
		
		    <label class="star star-3" for="star-3"></label>
		
		    <input class="star star-2" id="star-2" value="2" type="radio" name="star" />
		
		    <label class="star star-2" for="star-2"></label>
		
		    <input class="star star-1" id="star-1" value="1" type="radio" name="star" />
		
		    <label class="star star-1" for="star-1"></label>
	    </div>
	    <div>
	    	 <label for="comment"><b><h3>Comments:</h3></b></label>
    		<input type="text" placeholder="Enter comments" name="coment" >
	    </div>
	    <input type="submit" value="submit"/>
	    
  </form> 
  <%} %>
  	
  </div>
  </div>  
  </div>


</body>
</html>

