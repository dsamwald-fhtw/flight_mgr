<?php
function getRowLetter($value=0) {
  switch ($value) {
    case 1:
    return "A";
    break;
    case 2:
    return "B";
    break;
    case 3:
    return "C";
    break;
    case 4:
    return "D";
    break;
    case 5:
    return "E";
    break;
    case 6:
    return "F";
    break;
    case 7:
    return "G";
    break;
    case 8:
    return "H";
    break;
    case 9:
    return "I";
    break;
    case 10:
    return "J";
    break;
    case 11:
    return "K";
    break;
    case 12:
    return "L";
    break;
    case 13:
    return "M";
    break;
    case 14:
    return "N";
    break;
    case 15:
    return "O";
    break;
    case 16:
    return "P";
    break;
    case 17:
    return "Q";
    break;
    case 18:
    return "R";
    break;
    case 19:
    return "S";
    break;
    case 20:
    return "T";
    break;
  }
}

function isBooked($row=0, $seat="", $airline="", $flight="") {
  global $pdo;
  
  $statement = $pdo->prepare("SELECT * FROM passengers WHERE rownr = :row AND seatposition = :seat AND airline = :airline AND flightnr = :flight");
  $result = $statement->execute(array('row' => $row, 'seat' => $seat, 'airline' => $airline, 'flight' => $flight));
  $passenger = $statement->fetch();
  return $passenger;
}
?>
