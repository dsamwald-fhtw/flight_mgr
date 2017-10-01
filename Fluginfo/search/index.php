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
                 <td>Flightnumber</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Airline</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Departure Airport</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Departure Time</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Destination Airport</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Destination Time</td>
                 <td> </td>
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
                 <td>Planetype</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Max. Speed</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Initial Service</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Max. Seats</td>
                 <td></td>
               </tr>
               <tr>
                 <td>Seats per Row</td>
                 <td></td>
               </tr>
             </tbody>
           </table>
          </div>
        </div>
        <br />
        <div>
          <h3 class="finish_form_head">Passengers</h3>
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
              <tr>
                <td>Alvin</td>
                <td>Eclair</td>
                <td>1</td>
                <td><button class="btn btn-small waves-effect waves-light red darken-3" type="submit" name="action">Kick!</button></td>
              </tr>
              <tr>
                <td>Alan</td>
                <td>Jellybean</td>
                <td>2</td>
                <td><button class="btn btn-small waves-effect waves-light red darken-3" type="submit" name="action">Kick!</button></td>
              </tr>
              <tr>
                <td>Jonathan</td>
                <td>Lollipop</td>
                <td>3</td>
                <td><button class="btn btn-small waves-effect waves-light red darken-3" type="submit" name="action">Kick!</button></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
