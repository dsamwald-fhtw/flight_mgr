<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="http://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/stylesheet.css">
    <title>Web Flight Manager</title>
  </head>
  <body>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

    <?php
      require_once("php/connection.php");
      if(isset($_GET['search'])) {
        $text1 = strtoupper(trim($_POST['text1']));
        $text2 = trim($_POST['text2']);

        $statement = $pdo->prepare("SELECT * FROM flights WHERE flightnr = :flightnr AND airline = :airline");
        $result = $statement->execute(array('flightnr' => $text2, 'airline' => $text1));
        $flight = $statement->fetch();

        if($flight) {
          header("location: search/?airline=".$text1."&flight=".$text2);
        } else {
          echo "<script type='text/javascript'>Materialize.toast('This Flight does not exist, try again!', 10000);</script>";
        }
      }
      if(isset($_GET['error'])) {
        echo "<script type='text/javascript'>Materialize.toast('This Flight does not exist, try again!', 10000);</script>";
      }
    ?>

    <div class="number_head_bg"></div>
    <div class="number_page">
      <div class="number_head_wrap"></div>
      <div class="number_form_wrap">
        <form method="post" action="?search=1">
          <h3 class="number_form_head center-align">Flight Manager</h3>
          <p class="number_form_lead center-align">Enter Airline and Flightnumber<br>Example: AA-000</p>
          <div class='input-field col s6'>
            <div class="row">
              <div class="col s4">
                <input class="input-field" id="text1" name="text1" style="text-transform:uppercase" type="text" placeholder="AA" maxlength="2" value="<?php if(isset($_GET['search'])) { echo($text1); }?>" required />
              </div>
              <div class="col s1" style="padding-top: 10px;">
                <b>-</b>
              </div>
              <div class="col s7">
                <input class="input-field" id="text2" name="text2" type="text" maxlength="3" placeholder="000" min="000" max="999" value="<?php if(isset($_GET['search'])) { echo($text); }?>" required />
              </div>
            </div>
          </div>
          <br />
          <div class="col s6 center-align">
            <button type='submit' class='btn waves-effect button' style="width: auto;"><i class="material-icons left">search</i> Search</button>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
