<?php	
	include "../include/config.php";
	include "../include/session.php";
	
	//Запросы для чтения данных из БД
	$result_genre = mysqli_query($connection, "SELECT * FROM `the_series` WHERE `categorie_id` = $id");
	$result_id = mysqli_query($connection, "SELECT * FROM `the_series` WHERE `categorie_id` = $id");
	$result_title = mysqli_query($connection, "SELECT `title` FROM `the_series_categories` WHERE `id` = $id");
	
	//Сортировка по имени
	if(isset($_GET['sort_by_name'])) {
		include "../include/sort.php";
		$query = "SELECT * FROM `the_series` WHERE `categorie_id` = $id ORDER BY `title` $order";
		$result_genre = mysqli_query($connection, $query);
		$result_id = mysqli_query($connection, "SELECT `id` FROM `the_series` WHERE `categorie_id` = $id ORDER BY `title` $order");
	}
	
	//Сортировка по дате создания
	if(isset($_GET['sort_by_date'])) {
		include "../include/sort.php";
		$query = "SELECT * FROM `the_series` WHERE `categorie_id` = $id ORDER BY `pubdate` $order";
		$result_id = mysqli_query($connection, $query);
		$result_genre = mysqli_query($connection, "SELECT * FROM `the_series` WHERE `categorie_id` = $id ORDER BY `id` $order");
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Найди свой сериал | <?php /*while (($categories = mysqli_fetch_assoc($result_title))) { echo  ''.$categories['title'].';} */?> </title>
		<link rel = "stylesheet" href = "/styles/general.css">
		<link rel = "stylesheet" href = "/styles/sidebar_up.css">
		<link rel = "stylesheet" href = "/styles/sidebar_right.css">
	</head>

	<body>
		<div id="main">
			<header>
				<?php 
					while ( ($categories = mysqli_fetch_assoc($result_title)) ) {
						echo  '' .  $categories['title'] . '';
					} 
				?>
			</header>
			<? include "../include/sidebar_up.php"; ?>
			<section>
			<div id="sidebar_right">
				<? include "../include/registration.php"; ?>
				<div id="sort">
					<a id="sort_by_name" class="buttons" name = 'sort_by_name' href='genres.php?sort_by_name'>Сортировать по имени</a>
					<a id="sort_by_date" class="buttons" name = 'sort_by_date' href='genres.php?sort_by_date'>Сортировать по дате создания</a>
					<? include "../include/checkbox.php"; ?>
				</div>
			</div>
			<div id="describe_but">
				<?php 
					while ( ($id = mysqli_fetch_assoc($result_id)) and ($categories = mysqli_fetch_assoc($result_genre)) ) {
						echo '<a class="buttons" name = \'genres\' href=\'/genres/series/series.php?id=' . $id['id'] . '\'>' . $categories['title'] . '</a>';
					}
					mysqli_close($connection);
				?>
				<a class="buttons" id="add_but" href='genres_redaction.php'>Редактировать данные</a>
			</div>
			</section>
			<footer>
				Tarasov M.V. 222261 &copy; 2017
			</footer>
		</div>
	</body>
</html>