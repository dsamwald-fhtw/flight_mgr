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


    <div class="number_head_bg"></div>
    <div class="number_page">
      <div class="number_head_wrap"></div>
      <div class="number_form_wrap">
        <form method="post" action="?suchen=1">
          <h3 class="number_form_head center-align">Fluginformationen</h3>
          <p class="number_form_lead center-align">Flugnummer des Fluges eintragen</p>
          <div class='input-field col s6'>
            <input class="input-field" id="Nummer" name="Nummer" placeholder="Flugnummer" type="text" />
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
