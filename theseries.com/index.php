<?php
	include "/include/config.php";
	
	//Запросы для чтения из БД
	$result_id = mysqli_query($connection, "SELECT `id` FROM `the_series_categories`");
	$result_title = mysqli_query($connection, "SELECT `title` FROM `the_series_categories`");
	
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
					<a id="sort_by_name" class="buttons" name = 'sort_by_name' href='index.php?sort_by_name'>Сортировать по имени</a>
					<a id="sort_by_date" class="buttons" name = 'sort_by_date' href='index.php?sort_by_date'>Сортировать по дате создания</a>
					<? include "/include/checkbox.php"; ?>
				</div>
			</div>
			<div id="describe_but">
				<?php
					while ( ($categories = mysqli_fetch_assoc($result_title)) and ($id = mysqli_fetch_assoc($result_id)) ) {
						echo '<a class="buttons" name = \'genres\' href=\'/genres/genres.php?id=' . $id['id'] . '\'>' . $categories['title'] . '</a>';
					}
					mysqli_close($connection);
				?>
				<a class="buttons" id="add_but" href='index_redaction.php'>Редактировать данные</a>
			</div>
			</section>
			<footer>
				Tarasov M.V. 222261 &copy; 2017
			</footer>
		</div>	
	</body>
</html>