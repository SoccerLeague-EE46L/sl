        <html>
        
        <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
        <link type="text/css" rel="stylesheet" href="/stylesheet/flavor.css"/>
        
        
        <header>
			<h1><center>Welcome to Austin Regional Soccer Association</center></h1>
			<img src="/stylesheet/wallpaper.jpg" height="500" width="2000">
				<nav><ul>
					<li><a href="index.html">home</a></li>
					<li><a href="Statistics.jsp">Statistics</a></li>
					<li><a href="calendar.html">calendar</a></li>
					<li><a href="registration.jsp">Register</a></li>
					<li><a href="contact.html">contact us</a></li>
					<li><a href="LogIn.html">Log In</a></li>
					<li><a href="soccerleague">SoccerLeague</a></li>
					
				</ul></nav>
		</header>
        </head>
        <body>

        <form action="/register" method="get">

        <h1>Sign Up</h1>

        <fieldset>
        <legend><span class="number">1</span>Your basic info</legend>
        <label for="name">First Name:</label>
        <input type="text" id="firstName" name="first_name">

        <label for="name">Last Name:</label>
        <input type="text" id="lastName" name="last_name">

        <label for="mail">Address:</label>
        <input type="text" id="address" name="address">

        <label for="mail">Phone Number:</label>
        <input type="text" id="number" name="phone_number">

        <label>Age:</label>
        <input type="radio" id="under_13" value="under_13" name="user_age"><label for="under_13" class="light">Under 13</label><br>
        <input type="radio" id="over_13" value="over_13" name="user_age"><label for="over_13" class="light">13 or older</label>
        </fieldset>


        <fieldset>
        <label for="sport">Sport:</label>
        <select id="sport" name="sport">
        <option value="soccerLeague.SoccerPlayer">Soccer</option>
        <option value="soccerLeague.BasketballPlayer">Basketball</option>
        <option value="soccerLeague.FootballPlayer">Football</option>
        <option value="soccerLeague.BaseballPlayer">Baseball</option>
        <option value="soccerLeague.VolleyballPlayer">Volleyball</option>
        </optgroup>
        </select>
        </fieldset>
        <fieldset>
        <label>Positions:</label><br>
        <input type="checkbox" id="goalie" value="goalie" name="goalie"><label class="light" for="goalie">Goalie</label><br>
        <input type="checkbox" id="defender" value="defender" name="defender"><label class="light" for="defender">Defender</label><br>
        <input type="checkbox" id="midfielder" value="midfielder" name="midfielder"><label class="light" for="midfielder">Midfielder</label><br>
        <input type="checkbox" id="attacker" value="attacker" name="attacker"><label class="light" for="attacker">Attacker</label>
        </fieldset>
        <button type="submit">Sign Up</button>
        </form>

        </body>
        </html>