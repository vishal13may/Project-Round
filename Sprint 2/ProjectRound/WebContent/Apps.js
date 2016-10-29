$(document).ready(function() {
   
	var questionNo =1;
	var totalNoOfQuestion=4;
	var noOfCorrectAnswer=0;
	var choice1;
	var choice2;
	var choice3;
	var answer;
	
	 $.ajax({
         type: "GET",
         url: "Application",
         dataType: "json",
        
         // if received a response from the server
         success: function( data, textStatus, jqXHR) {
        	 	var question = data.Question.question;
        	 	choice1 = data.Question.choices[0];
        	 	choice2 = data.Question.choices[1];
        	 	choice3 = data.Question.choices[2];
        		answer = data.Question.answer;
        		
        		 $("#header").html("");
        	     $("#header").append("<h3> Question");
        	     $("#header").append(" "+questionNo);
        	     $("#header").append(" of");
        	     $("#header").append(" "+totalNoOfQuestion);
        	     $("#header").append("</h3>");
        	     
        	     
        	     $("#questions").html("");
        	     $("#questions").append("<br>");
        	     $("#questions").append(question);
        	     $("#questions").append("<br>");
        	     
        	     $("#questions").append("<input type=\"radio\" name=\"choice\" value=\"1\">");
        	     $("#questions").append(choice1);
        	     $("#questions").append("<br>");
        	     
        	     $("#questions").append("<input type=\"radio\" name=\"choice\" value=\"2\">");
        	     $("#questions").append(choice2);
        	     $("#questions").append("<br>");
        	     
        	     $("#questions").append("<input type=\"radio\" name=\"choice\" value=\"3\">");
        	     $("#questions").append(choice3);
        	     $("#questions").append("<br>");
        	     $("#questions").append("<br>");
        	     $("#questions").append("<br>");
        	     
         }
        
     });       
     
    // checks for the button click event
    $("#submit").click(function(e){
    	  if(questionNo === totalNoOfQuestion ){
    		  $("#header").html("");
              $("#header").append("<h3> Test Completed");
              $("#header").append("</h3>");
              
              var chk = $('#questions input:radio:checked');
        	  var value = chk.attr('value');
        	  if(value == answer){
        		  noOfCorrectAnswer++;
        	  }
              $("#questions").html("");
              $("#questions").append("<br>");
              $("#questions").append("You got "+ noOfCorrectAnswer +" out of " + totalNoOfQuestion +"questions correct");
              $("#questions").append("<br>");
              
              $("#footer").html("");
              
    	  }
    	  else{
    	  questionNo++;
    	  var chk = $('#questions input:radio:checked');
    	  var value = chk.attr('value');
    	  if(value == answer){
    		  noOfCorrectAnswer++;
    	  }
    	  
    	  $.ajax({
    	         type: "GET",
    	         url: "Application",
    	         dataType: "json",
    	        
    	         // if received a response from the server
    	         success: function( data, textStatus, jqXHR) {
    	        	 	var question = data.Question.question;
    	        	 	choice1 = data.Question.choices[0];
    	        	 	choice2 = data.Question.choices[1];
    	        	 	choice3 = data.Question.choices[2];
    	        		answer = data.Question.answer;
    	        		
    	                $("#header").html("");
    	                $("#header").append("<h3> Question");
    	                $("#header").append(" "+questionNo);
    	                $("#header").append(" of");
    	                $("#header").append(" "+totalNoOfQuestion);
    	                $("#header").append("</h3>");
    	                
    	                
    	                $("#questions").html("");
    	                $("#questions").append("<br>");
    	                $("#questions").append(question);
    	                $("#questions").append("<br>");
    	                
    	                $("#questions").append("<input type=\"radio\" name=\"choice\" value=\"1\">");
    	                $("#questions").append(choice1);
    	                $("#questions").append("<br>");
    	                
    	                $("#questions").append("<input type=\"radio\" name=\"choice\"  value=\"2\">");
    	                $("#questions").append(choice2);
    	                $("#questions").append("<br>");
    	                
    	                $("#questions").append("<input type=\"radio\" name=\"choice\"  value=\"3\">");
    	                $("#questions").append(choice3);
    	                $("#questions").append("<br>");
    	                $("#questions").append("<br>");
    	                $("#questions").append("<br>");
    	               
    	          	  }
    	           
    	   });
    	 }
     });

});