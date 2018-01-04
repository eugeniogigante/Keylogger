<?php
      if( $_GET["text_"]) {
      $textreceived = $_GET['text_'];
      echo "Welcome ". $textreceived . "<br />";
	  
	  $file = 'myfile.txt';
		// The new person to add to the file
		// Write the contents to the file, 
		// using the FILE_APPEND flag to append the content to the end of the file
		// and the LOCK_EX flag to prevent anyone else writing to the file at the same time
		file_put_contents($file, $textreceived .PHP_EOL, FILE_APPEND | LOCK_EX);
      
      exit();
   }
?>
<html>
   <body>  
	  <form action = "<?php $_PHP_SELF ?>" method = "GET">
         Name: <input type = "text" name = "text_" />
         <input type = "submit" />
      </form>
   
   </body>
</html>