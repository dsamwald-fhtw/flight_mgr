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
      if(isset($_GET['airline']) && isset($_GET['flight'])) {

        $text1 = $_GET['airline'];
        $text2 = $_GET['flight'];

        $statement = $pdo->prepare("SELECT * FROM flights WHERE flightnr = :flightnr AND airline = :airline");
        $result = $statement->execute(array('flightnr' => $text2, 'airline' => $text1));
        $flight = $statement->fetch();

        if($flight) {
          $statement = $pdo->prepare("SELECT * FROM airlines WHERE id = :id");
          $result = $statement->execute(array('id' => $text1));
          $airline = $statement->fetch();

          $statement = $pdo->prepare("SELECT * FROM planes WHERE id = :id");
          $result = $statement->execute(array('id' => $flight['planetype']));
          $plane = $statement->fetch();

          $rows = $plane['maxseats'] / $plane['seatsperrow'];
        } else {
          echo("<script>window.history.back();</script>");
        }
      } else {
        echo("<script>window.history.back();</script>");
      }
    ?>
    <div class="plane_head_bg"></div>
    <div class="plane_page">
      <div class="plane_head_wrap">
        <div class="row">
          <div class="col s4 left-align">
            <a href="<?php echo('../search/?airline='.$text1.'&flight='.$text2); ?>" style="background-color: #52509e !important;" class='btn btn-large waves-effect waves-light' type='submit' name='action'><i class="material-icons left">flight_takeoff</i> Back to Flight</a>
          </div>
          <div class="col s4 center-align">
            <h3 class="plane_form_head center-align">Flight Manager</h3>
          </div>
          <div class="col s4 right-align"></div>
        </div>
      </div>
      <div class="plane_form_wrap">
        <h3 class="finish_form_headsm center-align">Booking Seat of Flight: <?php echo($airline['id']."-".$flight['flightnr']); ?></h3>
        <div class="finish_form_info">
          <table>
           <tbody>
             <?php
              for($i = 1; $i <= $rows; $i++) {
                echo("<tr>");

                for($j = 1; $j <= $plane['seatsperrow']; $j++) {
                  if($j < $plane['seatsperrow'] / 2) {
                    if(isBooked($i, getRowLetter($j), $text1, $text2)) {
                      echo("<td class='right-align'>");
                      echo("<a style='width: 100%' class='btn btn-large waves-effect waves-light disabled' type='submit' name='action'>".$i."".getRowLetter($j)."</a>");
                      echo("</td>");
                    } else {
                      echo("<td class='right-align'>");
                      echo("<a href='' style='background-color: #52509e !important; color: white; width: 100%' class='btn btn-large btn-flat waves-effect waves-light' type='submit' name='action'>".$i."".getRowLetter($j)."</a>");
                      echo("</td>");
                    }
                  }  else {
                    if(isBooked($i, getRowLetter($j), $text1, $text2)) {
                      echo("<td class='left-align'>");
                      echo("<a style='width: 100%' class='btn btn-large waves-effect waves-light disabled' type='submit' name='action'>".$i."".getRowLetter($j)."</a>");
                      echo("</td>");
                    } else {
                      echo("<td class='left-align'>");
                      echo("<a href='' style='background-color: #52509e !important; color: white; width: 100%' class='btn btn-large btn-flat waves-effect waves-light' type='submit' name='action'>".$i."".getRowLetter($j)."</a>");
                      echo("</td>");
                    }
                  }
                }
                echo("</tr>");
              }
              ?>
           </tbody>
         </table>
        </div>
      </div>
    </div>
  </body>
</html>
