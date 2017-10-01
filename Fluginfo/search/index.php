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

          $statement = $pdo->prepare("SELECT id,firstname,lastname,rownr,seatposition FROM passengers WHERE airline = :airline AND flightnr = :flightnr ORDER BY id");
          $result = $statement->execute(array("airline" => $text1, "flightnr" => $text2));

          while ($passenger = $statement->fetch()) {
	           $passengers[] = $passenger;
	         }
        } else {
          header("location: ../?error=1");
        }
      } else {
        header("location: ../?error=1");
      }
    ?>

    <div class="finish_head_bg"></div>
    <div class="finish_page">
      <div class="finish_head_wrap"></div>
      <div class="finish_form_wrap">
        <h3 class="finish_form_head center-align">Flight Manager</h3>
        <div class="row">
          <div class="col s12 m6 l6 left-align finish_form_info">
            <table class="highlight">
             <thead>
               <tr>
                 <th>Flight Information</th>
                 <th></th>
               </tr>
             </thead>
             <tbody>
               <tr>
                 <td>Flightnumber:</td>
                 <td>#<?php echo($flight['flightnr']); ?></td>
               </tr>
               <tr>
                 <td>Airline:</td>
                 <td><?php echo($airline['name']); ?></td>
               </tr>
               <tr>
                 <td>Departure Airport:</td>
                 <td><?php echo($flight['departure_airport']); ?></td>
               </tr>
               <tr>
                 <td>Departure Time:</td>
                 <td><?php echo($flight['departure_time']); ?></td>
               </tr>
               <tr>
                 <td>Destination Airport:</td>
                 <td><?php echo($flight['destination_airport']); ?></td>
               </tr>
               <tr>
                 <td>Destination Time:</td>
                 <td><?php echo($flight['destination_time']); ?></td>
               </tr>
             </tbody>
           </table>
          </div>
          <div class="col s12 m6 l6 left-align finish_form_info">
            <table class="highlight">
             <thead>
               <tr>
                 <th>Airplane Information</th>
                 <th></th>
               </tr>
             </thead>
             <tbody>
               <tr>
                 <td>Planetype:</td>
                 <td><?php echo($plane['type']); ?></td>
               </tr>
               <tr>
                 <td>Max. Speed:</td>
                 <td><?php if($plane['maxspeed'] != null) {  echo($plane['maxspeed']." km/h"); } else { echo "Unknown";}?></td>
               </tr>
               <tr>
                 <td>Initial Service:</td>
                 <td><?php echo($plane['initialserviceyear']); ?></td>
               </tr>
               <tr>
                 <td>Max. Seats:</td>
                 <td><?php echo($plane['maxseats']); ?></td>
               </tr>
               <tr>
                 <td>Seats per Row:</td>
                 <td><?php echo($plane['seatsperrow']); ?></td>
               </tr>
             </tbody>
           </table>
          </div>
        </div>
        <br />
        <div>
          <table class="highlight centered">
            <thead>
              <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Seat</th>
                  <th>Kick Passenger</th>
              </tr>
            </thead>
            <tbody>
              <?php
                for($i = 0; $i < count($passengers); $i++) {
                  echo "<tr>
                    <td>".$passengers[$i][1]."</td>
                    <td>".$passengers[$i][2]."</td>
                    <td>".$passengers[$i][3]."".$passengers[$i][4]."</td>
                    <td><a href='kick/?id=".$passengers[$i][0]."&airline=".$text1."&flight=".$text2."' class='btn btn-small waves-effect waves-light red darken-3' type='submit' name='action'>Kick!</a></td>
                  </tr>";
                }
              ?>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
