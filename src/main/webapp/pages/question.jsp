<html>

<head>
${message}<br>

<img src="/images/${imagepath}" width=100 height=100><br>
 
welcome user ${username}<br><br>

<style>
		.hidden
		{
			display:none;
		}
		
		#maincontent
		{
		  padding: 18px;
          border: 5px solid black;
            /* text-align: center;*/
          width: 700px;
           margin: auto;
          background-color: black;
          color:white;
         
		}
		
		#one
		{
		  padding: 20px;
		  margin:25px;
		  display: inline-block;
		  width=30px;
		  padding: 20px;
		  background-color: black;
          color:white;
          border:none;
          text-align: right;
		}
		
		
		#two
		{
		  margin: 4px -41px;
          padding: 23px;
          width: 50%;
          box-sizing: border-box;
          display: inline-block;
		  background-color: black;
          color:white;
          border:none;
          text-align: left;
		}
		
		
</style>

<br><br>

<script>


function displayTime()
{
	sessionStorage.setItem("duration",sessionStorage.getItem("duration")-1);
	
	var remainingSeconds=sessionStorage.getItem("duration");

	var minutes=Math.floor(remainingSeconds/60);
	
	var seconds=remainingSeconds%60;
	
	document.getElementById("remainingtime").innerHTML="Remaining Time:"+ minutes + ":" + seconds;

	if(remainingSeconds==0)
	{
		location.href="/endexam";
	}
	
}


    setInterval(displayTime,1000);/* 1000 ms - 1 sec . It means displayTime() will be called after every 1 second  */


function changeColor()
{
						
	var allAnswers=document.getElementsByTagName("span");

	var allRadioButtons=document.getElementsByName("submittedAnswer");	

    var previousAnswer=document.getElementById("previousAnswer").value;
	
	for(var i=0;i<allAnswers.length;i++)

	
	{
			console.log(allAnswers[i].innerText.length)
			
			console.log(previousAnswer.length)
			
			if(allAnswers[i].innerText.trim()==previousAnswer.trim())
			{
				
				allAnswers[i].style.color="red";
				allRadioButtons[i].checked=true;
				break;
			}
	}
 }

</script>

<link rel="stylesheet" href="/css/common.css">

</head>


<body onload="changeColor()">


<p style="color:green; position: absolute; top: 0px; right: 50px; font-size: 30px;" id="remainingtime"></p>

<form name="questionForm">

<p style="color:red;font-size:50px; margin:91px -84px; padding:22px; position: absolute; top: 0px; left: 700px" > Exam Questions</p>
		
<div id="maincontent">	

	<input id="one" type="text" name="qno" value="${question.qno}">
	
	<input id="two" type="text" name="qtext" value="${question.qtext}" > <br><br>
	
	<%-- <textarea id="two" rows=3 cols=50 name="qtext" readonly> ${question.qtext} </textarea><br><br>--%>
		
	<input  type="radio" name="submittedAnswer" value="${question.op1}">  <span> ${question.op1} </span><br><br>
	
	<input  type="radio" name="submittedAnswer" value="${question.op2}">  <span> ${question.op2} </span> <br><br>
		
	<input  type="radio" name="submittedAnswer" value="${question.op3}"> <span> ${question.op3} </span> <br><br>
	
	<input  type="radio" name="submittedAnswer" value="${question.op4}"> <span> ${question.op4} </span> <br><br>
	
	<input class="hidden" type=text name="originalAnswer" value="${question.answer}" ><br><br>
	
    <input class="hidden" id="previousAnswer" value="${previousAnswer}"><br><br>	
    
	<input  type="submit" value="next" formaction="next" class="btn" >
	<input  type="submit" value="previous" formaction="previous" class="btn" >
	<input  type="submit" value="end exam" formaction="endexam"  class="btn">

<br><br>

<input style="color:red; border:none;  background-color: black" type="text" value="${message}"><br><br>

</div>	

</form>

</body>
</html>