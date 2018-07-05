<?php 
	include 'connection.php';
	$sel = "select * from user"; 
	$res = mysqli_query($conn,$sel) or die("noo"); 
	while($fet = mysqli_fetch_assoc($res)) 
	{ 
		$users["data"][] = $fet;  
	} 
	echo json_encode($users); 
?>