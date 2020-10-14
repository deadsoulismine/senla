<?php	
	include "../../include/config.php";
	include "../../include/session.php";
	
	//Запросы для чтения данных из БД
	$result_series = mysqli_query($connection, "SELECT `text` FROM `the_series` WHERE `id` = $id");
	$result_author = mysqli_query($connection, "SELECT `author` FROM `comments` WHERE `the_series_id` = $id");
	$result_text = mysqli_query($connection, "SELECT `text` FROM `comments` WHERE `the_series_id` = $id");
	$result_pubdate = mysqli_query($connection, "SELECT `pubdate` FROM `comments` WHERE `the_series_id` = $id");
	$result_id = mysqli_query($connection, "SELECT `id` FROM `comments` WHERE `the_series_id` = $id");
	$result_title = mysqli_query($connection, "SELECT `title` FROM `the_series` WHERE `id` = $id");
			
	//Добавление записей
	if ( ($_POST['author'] != '') && ($_POST['field'] != '') ) {
		// Переменные с формы
		$author = $_POST['author'];
		$text = $_POST['field'];
		$result = mysqli_query ($connection, "INSERT INTO `comments` (author,text,the_series_id) VALUES ('$author', '$text', '$id')");
	}
		
	// Удаление записей 
	if(isset($_GET['delete'])) {
		$delete = (int) $_GET['delete'];
		$query = "DELETE FROM `comments` WHERE `id` = $delete";
		$result = mysqli_query($connection, $query);
	}
	
	// Если запрос POST 
	if( ($_POST['update_text'] != '') && ($_POST['update_author']) != '' ){
		$update = (int) $_GET['update'];
		$update_text = htmlentities(mysqli_real_escape_string($connection, $_POST['update_text']));
		$update_author = htmlentities(mysqli_real_escape_string($connection, $_POST['update_author']));
		$query = "UPDATE `comments` SET `text` = '$update_text', `author` = '$update_author' WHERE `id` = $update";
		$result = mysqli_query($connection, $query) or die("Ошибка " . mysqli_error($connection)); 
	}
	
	//Блок перенаправления на исходную страницу после работы с БД
	if ( ($_POST['author'] != '') && ($_POST['field'] != '') ) {
		header("Location: http://theseries.com/genres/series/series.php");
		exit;
	}
	if(isset($_GET['delete'])) {
		header("Location: http://theseries.com/genres/series/series.php");
		exit;
	}
	if( ($_POST['update_text'] != '') && ($_POST['update_author']) != '' ){
		header("Location: http://theseries.com/genres/series/series.php");
		exit;
	}
	
	//Сортировка по имени
	if(isset($_GET['sort_by_name'])) {
		include "../../include/sort.php";
		$query = "SELECT `author` FROM `comments` WHERE `the_series_id` = $id ORDER BY `author` $order";
		$result_author = mysqli_query($connection, $query);
		$result_author = mysqli_query($connection, "SELECT `author` FROM `comments` WHERE `the_series_id` = $id ORDER BY `author` $order");
		$result_text = mysqli_query($connection, "SELECT `text` FROM `comments` WHERE `the_series_id` = $id ORDER BY `author` $order");
	}
	
	//Сортировка по дате создания
	if(isset($_GET['sort_by_date'])) {
		include "../../include/sort.php";
		$query = "SELECT * FROM `comments` WHERE `the_series_id` = $id ORDER BY `pubdate` $order";
		$result_pubdate = mysqli_query($connection, $query);
		$result_author = mysqli_query($connection, "SELECT `author` FROM `comments` WHERE `the_series_id` = $id ORDER BY `pubdate` $order");
		$result_text = mysqli_query($connection, "SELECT `text` FROM `comments` WHERE `the_series_id` = $id ORDER BY `pubdate` $order");
	}
?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Найди свой сериал | Рик и Морти </title>
		<link rel = "stylesheet" href = "/styles/series.css">
		<link rel = "stylesheet" href = "/styles/general.css">
		<link rel = "stylesheet" href = "/styles/sidebar_up.css">
		<link rel = "stylesheet" href = "/styles/sidebar_right.css">
	</head>
	<body>
	<div id="main">
		<header>
			<?php 
			while ( ($categories = mysqli_fetch_assoc($result_title)) ) {
				echo  '' .  $categories['title'] . '<br>';
			}
			?>
		</header>
		<? include "../../include/sidebar_up.php"; ?>
		<section id="content">
			<div id="sidebar_right">
				<? include "../../include/registration.php"; ?>
				<div id="sort">
					<a id="sort_by_name" class="buttons" name = 'sort_by_name' href='series.php?sort_by_name'>Сортировать по имени</a>
					<a id="sort_by_date" class="buttons" name = 'sort_by_date' href='series.php?sort_by_date'>Сортировать по дате создания</a>
				</div>
				<? include "../../include/checkbox.php"; ?>
			</div>
			<div id = "picture"> 
				<img src= "" >
			</div>
			<div id = "describe">
				<?php 
					while ( ($categories = mysqli_fetch_assoc($result_series)) )
					{
						echo  ''. $categories['text'] . '';
					}
				?>
			</div>
		</section>
		<section>
			<table>
				<tr> <th> Автор </th> <th> Комментарий </th> <th> Дата написания </th> <th> Функции </th> </tr>
				<?php
				while ( ($author = mysqli_fetch_assoc($result_author)) and ($text = mysqli_fetch_assoc($result_text)) and ($pubdate = mysqli_fetch_assoc($result_pubdate)) and ($id = mysqli_fetch_assoc($result_id)) )
					{
						echo '<tr> <td>' . $author['author'] . '</td> 
						           <td>' . $text['text'] . '</td> 
								   <td>' . $pubdate['pubdate'] . ' </td> 
								   <td>  <div id="icons_series"><a id="delete" name = \'delete\' href=\'series.php?delete=' . $id['id'] . '\'> <img src= "/images/deletecom.png"></a> 
														 <a id="update" name = \'update\' href=\'series.php?update=' . $id['id'] . '\'> <img src= "/images/pencilcom.png"></a> 
										 </div>
								   </td> </tr>';
					}
				?>
			</table> 
		</section>
		<section class="form">
			<h2> Напишите комментарий </h2>
			<form name="add_comments"  method="post">
				<textarea name="field" placeholder="Введите текст комментария" rows="8" cols="69"></textarea> <br>
				<input type="text" name="author" placeholder="Введите ваше имя"/> 
				<input type="submit" name="send" value="Добавить комментарий"/>
			</form>
		<?php
		// Редактирование записей
		// Если запрос GET
		if(isset($_GET['update'])){
		//Создание формы для редактирования данных
        echo "<div id='upd_form' class='form'> <h2> Отредактируйте данные:  </h2>
				<form method='post'>
					<textarea name='update_text' value='$update_text' placeholder='Введите текст комментария' rows='10' cols='45'/></textarea>
					<input type='text' name='update_author' value='$update_author' placeholder='Введите ваше имя' /></p>	
					<input type='submit' value='Сохранить'>
				</form>
			 </div>";
		}
		mysqli_close($connection);
		?> 
		</section>
		<footer>
			Tarasov M.V. 222261 &copy; 2017
		</footer>
	</div>	
	</body>
</html>