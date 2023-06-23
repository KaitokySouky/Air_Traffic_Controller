<!DOCTYPE html>
<html lang="en">
    <!-- divinectorweb.com -->
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ATC - Air Tarffic Controllar</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <style>
        


body {
  font-family: 'Open Sans', sans-serif;
  font-weight: 300;
  line-height: 1.42em;
  color:#A7A1AE;
  background-color:#1F2739;
  background-image: url('imgg/font.png');
}

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}
body {
	font-family: 'Montserrat', sans-serif;
}
header {
	height: 15vh;
	position: relative;
}
.vid-bg {
	position: absolute;
	right: 0;
	bottom: 0;
	min-width: 100%;
	min-height: 100%;
}
.nav-area {
	height: 60px;
	position: absolute;
	width: 100%;
	padding-top: 10px;
	padding-bottom: 10px;
	background-color: #344578;
}
.logo {
	margin: 10px 50px;
	font-size: 5em;
    font-weight: 800;
	height: 60px;
	float: left;
	color: #fff;
	font-size: 35px;
	text-transform: capitalize;
}
.menu-area {
	float: right;
	list-style: none;
	margin: 20px;
}
.menu-area li {
	display: inline-block;
	margin: 0 5px;
}
.menu-area li a {
	text-decoration: none;
	color: #fff;
	padding: 5px 10px;
	letter-spacing: 2px;
	font-weight: 700;
}
.menu-area li a:hover {
	color: rgb(0, 85, 255);
}
header .welcome-text {
	position: absolute;
	width: 100%;
	text-align: center;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
.welcome-text h2 {
	color: #461bba;
	font-size: 100px;
	margin: 0;
	font-family: 'Bebas Neue', sans-serif;
	/* -webkit-text-fill-color: transparent; */
	-webkit-text-stroke: 1px #aca8c3;
}
.welcome-text p {
	color: #ffffff;
	font-weight: bold;
	font-size: 20px;
	width: 45%;
	line-height: 1.8;
	margin: auto;
}
.btn {
	background: transparent;
	border: none;
	color: #aca8c3;
	padding: 15px 35px;
	font-weight: bold;

	font-size: 18px;
	text-transform: uppercase;
	border-radius: 25px;
	display: inline-block;
	margin-top: 30px;
	border: 3px solid #aca8c3;
	background:  #360fb7;
	
}
.btn:hover {
	background:  #aca8c3;
	color: #360fb7;
	border: 3px solid #360fb7;


}
/*responsive*/

@media (min-width: 767px) and (max-width: 991px) {
	.welcome-text p {
		width: 95%;
	}
}
@media (max-width: 767px) {
	.logo {
		float: none;
		text-align: center;
        margin: 5px 0;
		font-size: 23px;
		height: 45px;
		line-height: 45px;
	}
	.menu-area {
		float: none;
		text-align: center;
		margin: 0;
	}
	.menu-area li {
		margin: 0;
	}
	.menu-area li a {
		padding: 5px 2px;
		font-size: 12px;
	}
	
	.nav-area {
		height: 90px;
	}
	.welcome-text h2 {
		font-size: 40px;
		margin-bottom: 18px;
		-webkit-text-stroke: 1px #fff;
	}
	.welcome-text p {
		width: 90%;
		font-size: 14px;
		line-height: 1.5;
	}
}

.overlay
{
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #02202e;
  mix-blend-mode: overlay;
}





h1 {
  font-size:3em; 
  font-weight: 300;
  line-height:1em;
  text-align: center;
  color: #4DC3FA;
}

h2 {
  font-size:1em; 
  font-weight: 300;
  text-align: center;
  display: block;
  line-height:1em;
  padding-bottom: 0.5em;
  color: #FB667A;
}

h2 a {
  font-weight: 700;
  text-transform: uppercase;
  color: #FB667A;
  text-decoration: none;
}

.blue { color: #185875; }
.yellow { color: #FFF842; }

.container th h1 {
	  font-weight: bold;
	  font-size: 1em;
  text-align: left;
  color: #185875;
}

.container td {
	  font-weight: normal;
	  font-size: 1em;
  -webkit-box-shadow: 0 2px 2px -2px #0E1119;
	   -moz-box-shadow: 0 2px 2px -2px #0E1119;
	        box-shadow: 0 2px 2px -2px #0E1119;
}

.container {
	  text-align: left;
	  overflow: hidden;
	  width: 80%;
	  margin: 0 auto;
  display: table;
  padding: 0 0 8em 0;
}

.container td, .container th {
	  padding-bottom: 2%;
	  padding-top: 2%;
  padding-left:2%;  
}

/* Background-color of the odd rows */
.container tr:nth-child(odd) {
	  background-color: #323C50;
}

/* Background-color of the even rows */
.container tr:nth-child(even) {
	  background-color: #2C3446;
}

.container th {
	  background-color: #1F2739;
}

.container td:first-child { color: #FB667A; }

.container tr:hover {
   background-color: #464A52;
-webkit-box-shadow: 0 6px 6px -6px #0E1119;
	   -moz-box-shadow: 0 6px 6px -6px #0E1119;
	        box-shadow: 0 6px 6px -6px #0E1119;
}

.container td:hover {
  background-color: #FFF842;
  color: #403E10;
  font-weight: bold;
  
  box-shadow: #7F7C21 -1px 1px, #7F7C21 -2px 2px, #7F7C21 -3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;
  transform: translate3d(6px, -6px, 0);
  
  transition-delay: 0s;
	  transition-duration: 0.4s;
	  transition-property: all;
  transition-timing-function: line;
}

@media (max-width: 800px) {
.container td:nth-child(4),
.container th:nth-child(4) { display: none; }
}
.footer_section p {
  padding: 20px 0;
  margin: 0 auto;
  color: #454141;
  text-align: center;
  border-top: 1.2px solid #262929;
  width: 75%;
}


.footer_section {
  margin-top: 45px;
  font-weight: 500;
  align-items: center;
}





    </style>
</head>


<body>
 <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>

    <%
    // Establish a database connection
    String url = "jdbc:mysql://localhost:3304/simulator";
    String username = "root";
    String password = "";
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(url, username, password);

    
   
    



        
    
    
  
    
   
    
    %>


  <header>
    <!-- <video src="videos/flight4.mp4" class="vid-bg" autoplay loop muted></video> 
    <div class="overlay"></div> -->
    <div class="nav-area">
        <div class="logo" >ATC</div>

        <ul class="menu-area">
             
                <li><a href="home.html">Home</a></li>
                <li><a href="airoport.jsp">Aeroports</a></li>
                <li><a href="vol.jsp">volCreation</a></li>
                <li><a href="index.jsp">simulation</a></li>
                 <li><a href="affichevol.jsp">Vols</a></li>
           
        </ul>
    </div>
  </header>  

    <div class="welcome-text">
  
    <!-- <h1><span class="blue">&lt;</span>Table<span class="blue">&gt;</span> <span class="yellow">Responsive</pan></h1> -->
        <h2>Flights table</h2>
         <table class="container">
            <thead>
                <tr>
                    <th><h1>départ</h1></th>
                    <th><h1>arrivée</h1></th>
                    <th><h1>altitude</h1></th>
                    <th><h1>avion</h1></th>
                    <th><h1>heuredépart</h1></th>
                    <th><h1>heureArrivée</h1></th>
                </tr>
            </thead>
            <tbody>
            <% 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vol");
            
          
            
            
            
    while (rs.next()) {
    	
        int depart = rs.getInt("départ");
        int arrivee=rs.getInt("arrivée");
       int altitudea=rs.getInt("altitude");
       int avion=rs.getInt("avion");
       int heuredépart=rs.getInt("heuredépart");
       int heureArrivée=rs.getInt("heureArrivée");
       
       PreparedStatement pstt = conn.prepareStatement("SELECT type FROM avion WHERE idavion = ?");
       pstt.setInt(1, avion);
       ResultSet ress= pstt.executeQuery();

       String type = "";
       if (ress.next()) {
           type = ress.getString("type");
       } 
       
       
       PreparedStatement pstj = conn.prepareStatement("SELECT nom FROM aeroport WHERE idaeroport = ?");
       pstj.setInt(1, depart);
       ResultSet rsDeparts= pstj.executeQuery();

       String nomaeroportdepart = "";
       if (rsDeparts.next()) {
           nomaeroportdepart = rsDeparts.getString("nom");
       } 

       
       PreparedStatement pstr = conn.prepareStatement("SELECT nom FROM aeroport WHERE idaeroport = ?");
       pstr.setInt(1, arrivee);
       ResultSet rsArrives = pstr.executeQuery();

       String nomaeroportarrive = "";
       if (rsArrives.next()) {
           nomaeroportarrive = rsArrives.getString("nom");
       } 
              
       %>
       
         <tr>
                    <td><%=nomaeroportdepart %> </td>
                    <td><%=nomaeroportarrive%></td>
                    <td><%=altitudea%></td>
                    <td><%=type%></td>
                    <td><%=heuredépart%></td>
                    <td><%=heureArrivée%></td>
                </tr><% 
    }
    rs.close();
    stmt.close();
    conn.close();
    
    %>
    
    
            </tbody>
        </table>

          
      </div>
      
    <!-- footer section -->
    <section class=" footer_section">
      <p>
        Copyright &copy; 2023 All Rights Reserved By IKSO
                </p>
    </section>
    <!-- footer section -->

</body>
</html>