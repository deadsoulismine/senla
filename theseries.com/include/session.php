<?php 
	//Создание сессии для хранения ID родительской таблицы
	session_start();
	if ($_GET['id'] != NULL) 
		$_SESSION['id'] = $_GET['id'];
	$id = $_SESSION['id'];
?>