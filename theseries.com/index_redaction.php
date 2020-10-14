<?php
	include "/include/config.php";
	
	//Запросы для чтения данных из базы
	$result_id = mysqli_query($connection, "SELECT `id` FROM `the_series_categories`");
	$result_title = mysqli_query($connection, "SELECT `title` FROM `the_series_categories`");
		
	// Удаление записей 
	if(isset($_GET['delete'])) {
		$delete = (int) $_GET['delete'];
		$query = "DELETE FROM `the_series_categories` WHERE `id` = $delete";
		$result = mysqli_query($connection, $query);
	}
	
	// Редактирование записей
	// Если запрос POST 
	if  ($_POST['update_title'] != '') {
		$update = (int) $_GET['update'];
		$update_title = htmlentities(mysqli_real_escape_string($connection, $_POST['update_title']));
		$query = "UPDATE `the_series_categories` SET `title` = '$update_title' WHERE `id` = $update";
		$result = mysqli_query($connection, $query) or die("Ошибка " . mysqli_error($connection)); 
	}
	
	//Добавление записей
	if ($_POST['add_title'] != '') {
		// Переменные с формы
		$title = $_POST['add_title'];
		$result = mysqli_query ($connection, "INSERT INTO `the_series_categories` (title) VALUES ('$title')");
	}	
	
	//Сортировка по имени
	if(isset($_GET['sort_by_name'])) {
		include "/include/sort.php";
		$query = "SELECT * FROM `the_series_categories` ORDER BY `title` $order";
		$result_title = mysqli_query($connection, $query);
		$result_id = mysqli_query($connection, "SELECT `id` FROM `the_series_categories` ORDER BY `title` $order");
	}
	
	//Сортировка по дате создания
	if(isset($_GET['sort_by_date'])) {
		if (isset($_POST['checkbox']) && $_POST['checkbox'] == 'YES')
		include "/include/sort.php";
		$query = "SELECT `id` FROM `the_series_categories` ORDER BY `id` $order";
		$result = mysqli_query($connection, $query);
		$result_title = mysqli_query($connection, "SELECT * FROM `the_series_categories` ORDER BY `id` $order");
	}
	
	//Блок перенаправления на исходную страницу после работы с БД
	if(isset($_GET['delete'])) {
		header("Location: http://theseries.com/index_redaction.php");
		exit;
	}
	
	if ($_POST['update_title'] != ''){
		header("Location: http://theseries.com/index_redaction.php");
		exit;
	}
	
	if ($_POST['add_title'] != ''){
		header("Location: http://theseries.com/index_redaction.php");
		exit;
	}	
	
	$uploaddir= '/images/'; 
?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Найди свой сериал | Главная </title>
		<link rel = "stylesheet" href = "/styles/general.css">
		<link rel = "stylesheet" href = "/styles/sidebar_up.css">
		<link rel = "stylesheet" href = "/styles/sidebar_right.css">
	</head>
	<body>
		<div id="main">
			<header>
				Найди свой сериал
			</header>
			<? include "/include/sidebar_up.php"; ?>
			<section>
			<div id="sidebar_right">
				<? include "/include/registration.php"; ?>
				<div id="sort">
					<a id="sort_by_name" class="buttons" name = 'sort_by_name' href='index_redaction.php?sort_by_name'>Сортировать по имени</a>
					<a id="sort_by_date" class="buttons" name = 'sort_by_date' href='index_redaction.php?sort_by_date'>Сортировать по дате создания</a>
					<? include "/include/checkbox.php"; ?>
				</div>
			</div>
			<div id="describe_but">
				<?php
					while ( ($categories = mysqli_fetch_assoc($result_title)) and ($id = mysqli_fetch_assoc($result_id)) ) {
						echo '<a class="buttons" name = \'genres\' href=\'genres.php?id=' . $id['id'] . '\'>' . $categories['title'] . '</a>
						      <div id="icons">
									<a id="delete" name = \'delete\' href=\'index_redaction.php?delete=' . $id['id'] . '\'><img src= "/images/delete.png"></a> 
									<a id="update" name = \'update\' href=\'index_redaction.php?update=' . $id['id'] . '\'><img src= "/images/pencil.png"></a> 
							  </div>';
					}
				?>
				<a class="buttons" id="add_but" name = "add_title" href='index_redaction.php?add_title'>Добавить жанр</a>
				<?php 
					// Редактирование записей 
					// Если запрос GET
					if(isset($_GET['update'])){
						//Создание формы для редактирования данных
						echo "<div id='upd_form' class='form'>
						<form method='post'>
							<h5> Отредактируйте название жанра: </h2>
							<input type='text' name='update_title' value='$update_title' placeholder='Отредактируйте название жанра' /></p>	
							<input type='submit' value='Сохранить'>
						</form>
						</div>";
					}
				
					if(isset($_GET['add_title'])){
					// Добавление записей
					// Создание формы для добавления данных
					echo "<div id='add_form' class='form'> <h2> Введите название нового жанра:  </h2>
						<form method='post'>
							<input type='text' name='add_title' value='$add_title' placeholder='Введите название нового жанра' /></p>	
							<input type='submit' value='Сохранить'>
							
						</form>
						</div>";
					}
					mysqli_close($connection);
				?> 	
			</div>
			</section>
			<footer>
				Tarasov M.V. 222261 &copy; 2017
			</footer>
		</div>	
	</body>
</html>