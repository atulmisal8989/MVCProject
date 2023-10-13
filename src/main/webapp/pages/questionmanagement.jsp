<html>

<head>

<style>
div
{
	text-align:center;
	border:1px solid grey;
	padding:30px;
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
		
.ttn
{
  padding:15px 30px;
  background-color: yellow;
  color:green;
  border-radius:10%;
  font-size:15px;
}

#four
{
   text-align: center;
   color: red;
   margin-top: 20px;
}	

</style>

</head>

<body  style="background-color: #f1b6b0;">

<h1 id="four">Question Management Page</h1>


<form>

<div id="maincontent">
	Ques No:- <input type="text" name="qno" placeholder="Enter question number" value="${question.qno}"><br><br>
	
	Question:- <input type="text" name="qtext" placeholder="Enter question" value="${question.qtext}"><br><br>
		
	option1 :- <input type="text" name="op1" placeholder="Enter option" value="${question.op1}"><br><br>
	
	option2 :- <input type="text" name="op2" placeholder="Enter option" value="${question.op2}"><br><br>
		
	option3 :- <input type="text" name="op3" placeholder="Enter option" value="${question.op3}"><br><br>
	
	option4 :- <input type="text" name="op4" placeholder="Enter option" value="${question.op4}"><br><br>
		
	Answer :- <input type="text" name="answer" placeholder="Enter Answer" value="${question.answer}"><br><br>
	
	subject :- <input type="text" name="subject" placeholder="Enter subject" value="${question.subject}"><br><br>
	
		
	<input type="submit" value="addQuestion" formaction="addQuestion" class="ttn">
	<input type="submit" value="viewQuestion" formaction="viewQuestion" class="ttn">
	<input type="submit" value="deleteQuestion" formaction="deleteQuestion" class="ttn">
	<input type="submit" value="updateQuestion" formaction="updateQuestion" class="ttn">

</div>	
</form>

<span style="color:blue;font-size:larger;text-align: center;margin-top: 30px;font-size:30px" > ${message} </span>

</body>

</html>