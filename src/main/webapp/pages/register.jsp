
<html>

<head>

	<script>

	        function change(input)
			{
		       		input.style.color="white";
		       		input.style.background="black";
	        }
	        
    </script>
   
	
</head>


<h1> Register page </h1>

<form enctype="multipart/form-data" method="post">

		<input type="text"  name="username" placeholder="Enter username" onfocus="change(this)" > <br><br>
		
		<input type="password" name="password" placeholder="Enter password"  placeholder="password" onfocus="change(this)"> <br><br>
		
		<input type="text" name="mobno" placeholder="Enter mobno" onfocus="change(this)"> <br><br>
		
		<input type="email"  name="emailid" placeholder="Enter email" onfocus="change(this)"> <br><br>
		
		<input type="file"  name="images"> <br><br>
		
		<input type="submit" value="register" formaction="saveToDB" > 
			
</form>