  <html>
  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Team Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>

      <form action="/maketeam" method="get">
      
        <h1>Team Info</h1>
        
        <fieldset>
          <legend><span class="number"></span>Team Information</legend>
          <label for="name">Team Name:</label>
          <input type="text" id="teamName" name="teamName">
        </fieldset>
        

        <fieldset>
        <label for="sport">Division:</label>
        <select id="division" name="division">
            <option value="soccerLeague.SoccerPlayer">premier</option>
            <option value="soccerLeague.BasketballPlayer">div1</option>
            <option value="soccerLeague.FootballPlayer">div2</option>
          </optgroup>
        </select>
        </fieldset>
          <fieldset>
          <label>Looking For Players:</label><br>
          <input type="checkbox" id="goalie" value="goalie" name="goalie"><label class="light" for="goalie">Goalie</label><br>
          <input type="checkbox" id="defender" value="defender" name="defender"><label class="light" for="defender">Defender</label><br>
          <input type="checkbox" id="midfielder" value="midfielder" name="midfielder"><label class="light" for="midfielder">Midfielder</label><br>
          <input type="checkbox" id="attacker" value="attacker" name="attacker"><label class="light" for="attacker">Attacker</label>
          </fieldset>
        <button type="submit">Register Team</button>
      </form>
      
    </body>
</html>