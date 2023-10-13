<html>

<head>

	<style>
	
		input,select
		{
		  padding:10px;
		}
				
		#maincontent
		{
		  padding: 18px;
          border: 5px solid black;
          text-align: center;
          width: 700px;
           margin: auto;
          background-color: black;
          color:white;         
		}
		
   </style>
		
		
		<script>

	         sessionStorage.setItem("duration",121);
	
        </script>
        
        <link rel="stylesheet" href="/css/common.css">
</head>

<body>


<form>

<h1 style="text-align: center; color:red;margin-bottom:50px;font-size:50px" > Online Exam Portal</h1>


<div id="maincontent">

		<input name="username" placeholder="username">  <br><br>
		
		<input type="password" name="password" placeholder="password" > <br><br>
		
		<select name="subject"> 
			
		<option>select subject</option>
		<option>java</option>
		<option value="gk">General Knowledge</option>
		
	    </select><br><br>
	    
		<input type="submit" value="sign in" formaction="validate" formmethod="post" class="btn"> 
		
    	<input type="submit" value='sign up' formaction="register" formmethod="post" class="btn">
				
		<span style="color:red;font-size:larger"> ${message} </span>
</div>
		
</form>

</body>

</html>