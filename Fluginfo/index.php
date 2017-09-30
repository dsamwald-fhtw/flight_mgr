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
        $flightnr = trim($_POST['flightnr']);

        $statement = $pdo->prepare("SELECT * FROM flights WHERE flightnr = :flightnr");
        $result = $statement->execute(array('flightnr' => $flightnr));
        $flight = $statement->fetch();

        if($flight != false) {
          header("location: search/?flightnr=".$flightnr);
        } else  {
          echo "<script type='text/javascript'>Materialize.toast('Dieser Flug existiert nicht, versuche es erneut!', 10000);</script>";
        }
      }
    ?>

    <div class="number_head_bg"></div>
    <div class="number_page">
      <div class="number_head_wrap"></div>
      <div class="number_form_wrap">
        <form method="post" action="?search=1">
          <h3 class="number_form_head center-align">Fluginformationen</h3>
          <p class="number_form_lead center-align">Flugnummer des Fluges eintragen</p>
          <div class='input-field col s6'>
            <input class="input-field" id="flightnr" name="flightnr" placeholder="Flugnummer" type="number" maxlength="3" min="000" max="999" />
          </div>
          <br />
          <div class="col s6 center-align">
            <button type='submit' class='btn waves-effect button' style="width: auto;"><i class="material-icons left">search</i> Suchen</button>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
