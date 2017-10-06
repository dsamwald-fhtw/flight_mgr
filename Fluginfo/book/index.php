<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="http://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/stylesheet.css">
    <title>Web Flight Manager</title>
  </head>
  <body>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>
    <?php
      require_once("../php/connection.php");
      require_once("../php/script.php");
      if(isset($_GET['airline']) && isset($_GET['flight']) && isset($_GET['row']) && isset($_GET['seat'])) {

        $text1 = $_GET['airline'];
        $text2 = $_GET['flight'];
        $text3 = $_GET['row'];
        $text4 = $_GET['seat'];

        $statement = $pdo->prepare("SELECT * FROM passengers WHERE rownr = :row AND seatposition = :pos AND airline = :airline AND flightnr = :flight");
        $result = $statement->execute(array('row' => $text3, 'pos' => $text4, 'airline' => $text1, 'flight' => $text2));
        $passenger = $statement->fetch();

        if(!$passenger) {
          if(isset($_GET['book'])) {
            $firstname = $_POST['firstname'];
            $lastname = $_POST['lastname'];

            $statement = $pdo->prepare("INSERT INTO passengers (firstname, lastname, airline, flightnr, rownr, seatposition) VALUES (:fname, :lname, :airline, :flight, :row, :seat)");
            $result = $statement->execute(array('fname' => $firstname, 'lname' => $lastname, 'airline' => $text1, 'flight' => $text2, 'row' => $text3, 'seat' => $text4));

            if($result) {
              header("location: ../plane/?airline=".$text1."&flight=".$text2."&success=1");
            } else {
              echo "<script type='text/javascript'>Materialize.toast('Something went wrong, please try again!', 10000);</script>";
            }
          }
        } else {
          header("location: ../plane/?airline=".$text1."&flight=".$text2."&error=1");
        }
      } else {
        echo("<script>window.history.back();</script>");
      }
    ?>
    <div class="book_head_bg"></div>
    <div class="book_page">
      <div class="book_head_wrap"></div>
      <div class="book_form_wrap">
        <form method="post" action="<?php echo('?airline='.$text1.'&flight='.$text2.'&row='.$text3.'&seat='.$text4.'&book=1'); ?>">
          <h3 class="book_form_head center-align">Booking Seat</h3>
          <p class="book_form_lead center-align"><?php echo("Flight: ".$text1."-".$text2."<br>Seat: ".$text3."".$text4); ?></p>
          <div class='input-field col s6'>
            <div class="row">
              <div class="col s12 input-field">
                <input class="input-field" id="firstname" name="firstname" type="text" value="<?php if(isset($_GET['book'])) { echo($firstname); }?>" required />
                <label for="firstname">First Name</label>
              </div>
              <div class="col s12 input-field">
                <input class="input-field" id="lastname" name="lastname" type="text" value="<?php if(isset($_GET['book'])) { echo($lastname); }?>" required />
                <label for="lastname">Last Name</label>
              </div>
            </div>
          </div>
          <br />
          <div class="col s6 center-align">
            <button type='submit' style="background-color: #52509e !important;" class='btn waves-effect' style="width: auto;">Book</button>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
