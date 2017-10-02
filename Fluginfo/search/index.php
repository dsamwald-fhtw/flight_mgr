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

        if(isset($_GET['error'])) {
          echo "<script type='text/javascript'>Materialize.toast('Passenger does not exist or did not get kicked!', 10000);</script>";
        }
        if(isset($_GET['success'])) {
          echo "<script type='text/javascript'>Materialize.toast('Passenger successfully kicked from flight!', 10000);</script>";
        }
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
      <div class="finish_head_wrap">
        <div class="row">
          <div class="col s4 left-align">
            <a href='../' style="background-color: #52509e !important;" class='btn btn-large waves-effect waves-light' type='submit' name='action'><i class="material-icons left">search</i> Search other Flight</a>
          </div>
          <div class="col s4 center-align">
            <h3 class="finish_form_head center-align">Flight Manager</h3>
          </div>
          <div class="col s4 right-align" id="button">
            <a onclick="changeShow(1)" style="background-color: #52509e !important;" class='btn btn-large waves-effect waves-light' type='submit' name='action'><i class="material-icons left">visibility</i> Show All informations</a>
          </div>
        </div>
      </div>
      <div class="finish_form_wrap">
        <div class="row" id="flightplaneinfo">
          <h3 class="finish_form_headsm center-align">Flight: <?php echo($airline['id']."-".$flight['flightnr']); ?></h3>
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
                   <td><?php echo($airline['id']."-".$flight['flightnr']); ?></td>
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
                   <td><?php echo(date("d.m.Y h:i", strtotime($flight['departure_time']))); ?></td>
                 </tr>
                 <tr>
                   <td>Destination Airport:</td>
                   <td><?php echo($flight['destination_airport']); ?></td>
                 </tr>
                 <tr>
                   <td>Destination Time:</td>
                   <td><?php echo(date("d.m.Y h:i", strtotime($flight['destination_time']))); ?></td>
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
                 <tr>
                   <td>Free Seats</td>
                   <td><?php echo($plane['maxseats'] - count($passengers)); ?></td>
                 </tr>
               </tbody>
             </table>
            </div>
          </div>
        </div>
        <div id="passengerlist">
          <h3 class="finish_form_headsm center-align">Passengers: <?php echo($airline['id']."-".$flight['flightnr']); ?></h3>
          <div class="finish_form_list">
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
                      <td><a href='../kick/?id=".$passengers[$i][0]."&airline=".$text1."&flight=".$text2."' class='btn btn-small waves-effect waves-light red darken-3' type='submit' name='action'>Kick!</a></td>
                    </tr>";
                  }
                ?>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="fixed-action-btn scale-transition tooltipped" data-position="top" data-delay="50" data-tooltip="Book new Seat" style="margin-bottom: 15px">
      <a style="background-color: #52509e !important;" class="btn btn-large waves-effect waves-light">
        <i class="material-icons left">event_seat</i> Book new Seat
      </a>
    </div>

    <script>
      function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
      }

      function changeShow(i) {
        if(i == 1) {
          document.getElementById('button').innerHTML = "<a onclick='changeShow(2)' style='background-color: #52509e !important;' class='btn btn-large waves-effect waves-light' type='submit' name='action'><i class='material-icons left'>flight_takeoff</i> Show Flight/Plane informations</a>";
          document.getElementById('flightplaneinfo').style = "display: unset;";
          document.getElementById('passengerlist').style = "display: none;";
          document.cookie = "view=2;";
        }
        if(i == 2) {
          document.getElementById('button').innerHTML = "<a onclick='changeShow(3)' style='background-color: #52509e !important;' class='btn btn-large waves-effect waves-light' type='submit' name='action'><i class='material-icons left'>group</i> Show Passengers List</a>";
          document.getElementById('flightplaneinfo').style = "display: none;";
          document.getElementById('passengerlist').style = "display: unset;";
          document.cookie = "view=3;";
        }
        if(i == 3) {
          document.getElementById('button').innerHTML = "<a onclick='changeShow(1)' style='background-color: #52509e !important;' class='btn btn-large waves-effect waves-light' type='submit' name='action'><i class='material-icons left'>visibility</i> Show All informations</a>";
          document.getElementById('flightplaneinfo').style = "display: unset;";
          document.getElementById('passengerlist').style = "display: unset;";
          document.cookie = "view=1;";
        }
      }

      var view = getCookie("view");
      if(view == null || view == "") {
        document.cookie = "view=1;";
      }
      if(view == 1) {
        changeShow(3);
      }
      if(view == 2) {
        changeShow(1);
      }
      if(view == 3) {
        changeShow(2);
      }
    </script>
    <script>
    $(document).ready(function(){
      $('.tooltipped').tooltip({delay: 50});
    });
    </script>
  </body>
</html>
