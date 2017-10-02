<?php
require_once("../php/connection.php");
  if(isset($_GET['id']) && isset($_GET['airline']) && isset($_GET['flight'])) {
    $text1 = $_GET['id'];
    $text2 = $_GET['airline'];
    $text3 = $_GET['flight'];

    $statement = $pdo->prepare("SELECT * FROM passengers WHERE id = :id AND airline = :airline AND flightnr = :flightnr");
    $result = $statement->execute(array('id' => $text1, 'airline' => $text2, 'flightnr' => $text3));
    $passenger = $statement->fetch();

    if($passenger) {
      $statement = $pdo->prepare("DELETE FROM passengers WHERE id = :id AND flightnr = :flightnr");
      $result = $statement->execute(array('id' => $text1, 'flightnr' => $text3));

      if($result) {
        header("location: ../search/?airline=".$text2."&flight=".$text3."&success=1");
      } else {
        header("location: ../search/?airline=".$text2."&flight=".$text3."&error=1");
      }
    } else {
      header("location: ../search/?airline=".$text2."&flight=".$text3."&error=1");
    }
  } else {
    header('Location: ' . $_SERVER['HTTP_REFERER']);
  }
?>
